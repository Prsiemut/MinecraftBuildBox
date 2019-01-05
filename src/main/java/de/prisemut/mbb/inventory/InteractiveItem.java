package de.prisemut.mbb.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;

public interface InteractiveItem {

    void onClick(InteractiveInventory interactiveInventory, InventoryAction action);

    ItemStack getItem(Player player);

    String getName();
}
