package de.prisemut.mbb.inventory;

import de.prisemut.mbb.MinecraftBuildingBox;
import de.prisemut.mbb.inventory.items.ChangeSiteItem;
import de.prisemut.mbb.inventory.items.SaveItem;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.concurrent.Callable;

@Data
public class InteractiveInventory {

    private final Player inventoryOwner;
    private final String name;
    private final int size;
    private final int rows;
    private Callable onSaveCallable;
    private Callable onCancelCallable;
    private boolean moveItemsEnabled = false;
    private boolean loggingEnabled = false;
    private boolean multiSite;
    private boolean saveOptions;
    private int site = 1;
    private int maxSite = 1;
    private Inventory inventory;
    private String displayName;
    private InteractiveItem[] items;
    private InteractiveItem[] addedItems;
    private Sound openSound;
    private Sound itemClickSound;
    private Sound saveSound;
    private Sound cancelSound;

    public InteractiveInventory(Player inventoryOwner, int rows, String displayName, String name) {
        this.inventoryOwner = inventoryOwner;
        this.rows = rows;
        this.size = 9 * rows;
        this.displayName = displayName;
        this.name = name;

        this.items = new InteractiveItem[this.size];
        this.addedItems = new InteractiveItem[this.size];
        this.inventory = Bukkit.createInventory(inventoryOwner, size, this.getDisplayName());
    }

    /**
     * Öffnet dem Spieler das erstellte InteractiveInventory.
     * Der Spieler wird im InventoryManager registriert und
     * falls festgelegt der openSound abgespielt.
     */
    public void open() {
        MinecraftBuildingBox.getInstance().getInventoryManager().addInventory(this.getInventoryOwner(), this);

        if (openSound != null)
            this.getInventoryOwner().playSound(this.getInventoryOwner().getLocation(), this.getOpenSound(), 1f, 1f);

        buildInventory();
        this.getInventoryOwner().openInventory(this.getInventory());
    }

    /**
     * Updated die gerade geöffnete Seite.
     * Dabei wird das Inventar gelöscht und neu generiert.
     * Wenn die Seite nicht exzistiert.
     * @param newSite Die neue Seite, welche geöffnet werden soll.
     */
    public void setSite(int newSite) {
        if (newSite > maxSite)
            return;
        this.site = newSite;
        buildInventory();
    }

    /**
     * Fügt dem Inventar sowohl StandardItems (ChangeSiteItems, PlaceHolderItems), als auch
     * sonstige hinzugefügt Items hinzu.
     * Zudem wird das Inventar, sowie der Items-Array geleert.
     */
    private void buildInventory() {
        items = new InteractiveItem[this.getSize()];
        this.getInventory().clear();

        if (multiSite) {
            if (this.getSite() != 1)
                addDefaultItem(size - 7, new ChangeSiteItem(true));
            if (this.getSite() < maxSite)
                addDefaultItem(size - 3, new ChangeSiteItem());
        }

        if (saveOptions){
            for (int i = 0; i < size / 9; i++) {
                addDefaultItem(i * 9, new SaveItem(true));
            }
            for (int i = 0; i < size / 9; i++) {
                addDefaultItem(8 + (i * 9), new SaveItem(false));
            }
        }

        addExtraItems();

        for (int i = 0; i < size; i++) {
            if (addedItems[i] != null)
                addDefaultItem(i, addedItems[i]);
        }
    }

    /**
     * Fügt ein Item dem Items-Array, sowie direkt dem BukkitInventar selber hinzu.
     *
     * @param position Die Position des Items im Inventar.
     * @param item Das InteractiveItem, welches hinzugefügt wird.
     */
    private void addDefaultItem(int position, InteractiveItem item) {
        this.getInventory().setItem(position, item.getItem(this.getInventoryOwner()));
        items[position] = item;
    }

    /**
     * Entfernt alle Items aus dem Inventar, außer die letzte Reihe, wenn mehr als eine
     * Seite besteht.
     */
    public void cleanInventory() {
        if (multiSite) {
            for(int i = 0; i < getSize() - 9; i++){
                addedItems[i] = null;
            }
        }  else {
            for(int i = 0; i < getSize(); i++){
                addedItems[i] = null;
            }
        }
    }

    /**
     * Fügt ein Item dem Items-Array hinzu. Wird beim nächsten reload des Inventars angezeigt.
     * @param position Die Positon im Inventar.
     * @param item Das hinzugefügte Item.
     */
    public void addItem(int position, InteractiveItem item) {
        addedItems[position] = item;
    }

    /**
     * Spielt dem Inventarbesitzer den Sound ab, wenn er ein Item klickt
     */
    public void playClickSound() {
        if (this.getItemClickSound() != null)
            this.getInventoryOwner().playSound(this.getInventoryOwner().getLocation(), this.getItemClickSound(), 1f, 1f);
    }

    /**
     * Spielt dem Inventarbesitzer den Sound ab, wenn er speichert.
     */
    public void playSaveSound() {
        if (this.getSaveSound() != null)
            this.getInventoryOwner().playSound(this.getInventoryOwner().getLocation(), this.getSaveSound(), 1f, 1f);
    }

    /**
     * Spielt dem Inventarbesitzer den Sound ab, wenn er abbricht.
     */
    public void playCancelSound() {
        if (this.getCancelSound() != null)
            this.getInventoryOwner().playSound(this.getInventoryOwner().getLocation(), this.getCancelSound(), 1f, 1f);
    }

    /**
     * Schließt das Invetar, baut es neu und öffnet es erneut.
     */
    private void reopen() {
        this.getInventoryOwner().closeInventory();
        buildInventory();
        this.getInventoryOwner().openInventory(this.getInventory());
    }

    /**
     * @param position Die Position des Items.
     * @return Das Interactive-Item an der Position.
     */
    public InteractiveItem getItem(int position) {
        if (position > size - 1) {
            return null;
        }
        return items[position];
    }

    /**
     * Diese Funktion wird in einer externen Inventory-Instance überschrieben,
     * um so weitere Items dem Inventar hinzufügen zu können.
     * In dieser Klasse hat sie keine Funktion.
     */
    public void addExtraItems() { }
}
