package de.prisemut.mbb.inventory;


import org.bukkit.entity.Player;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Joschy
 *
 * Diese Klasse kontrolliert alle InteractiveInventories.
 * Es werden alle Instancen von geöffneten Inventories gespeichert und bei
 * bedarf entfernt oder hinzugefügt.
 */

public class InventoryManager {

    public Map<Player, InteractiveInventory> openInventories = new WeakHashMap<>();

    /**
     * Fügt ein neues offenes Inventar zur HashMap hinzu.
     * Sollte ein Spieler bereits ein Inventar geöffnet haben wird dieses ersetzt.
     *
     * @param player Der Spieler, welchem das Inventar angezeigt wird.
     * @param interactiveInventory Die Instance des InteractiveInventory, welches geöffnet wurde
     */
    public void addInventory(Player player, InteractiveInventory interactiveInventory) {
        if (openInventories.containsKey(player)) {
            player.closeInventory();
            openInventories.replace(player, interactiveInventory);
        } else {
            openInventories.put(player, interactiveInventory);
        }
    }

    /**
     * Gibt das geöffnete Inventar eines Spielers zurück.
     *
     * @param player Der Spieler, der gesucht wird.
     * @return InteractiveInventory Instance vom player
     */
    public InteractiveInventory getInventory(Player player) {
        return openInventories.getOrDefault(player, null);
    }

    /**
     * Entfernt einen Spieler aus der HashMap der geöffneten Inventare.
     *
     * @param player Der Spieler, welcher entfernt werden soll.
     */
    public void removePlayer(Player player) {
        if (openInventories.containsKey(player)) {
            openInventories.remove(player);
        }
    }


}

