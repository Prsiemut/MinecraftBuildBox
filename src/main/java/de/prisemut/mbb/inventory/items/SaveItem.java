package de.prisemut.mbb.inventory.items;

import de.prisemut.mbb.inventory.InteractiveInventory;
import de.prisemut.mbb.inventory.InteractiveItem;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@RequiredArgsConstructor
public class SaveItem implements InteractiveItem {

    private final boolean cancel;

    @Override
    public void onClick(InteractiveInventory interactiveInventory, InventoryAction action) {
        interactiveInventory.getInventoryOwner().closeInventory();

        if (interactiveInventory.getSaveSound() == null && interactiveInventory.getCancelSound() == null)
            interactiveInventory.playClickSound();

        if (cancel) {
            try {
                interactiveInventory.playCancelSound();
                interactiveInventory.getOnCancelCallable().call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                interactiveInventory.playSaveSound();
                interactiveInventory.getOnSaveCallable().call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ItemStack getItem(Player player) {
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, cancel ? (short) 14 : (short) 5);

        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(cancel ? "§cabbrechen" : "§aspeichern");

        item.setItemMeta(itemMeta);
        return item;
    }

    @Override
    public String getName() {
        return cancel ? "cancel_item" : "save_item";
    }
}
