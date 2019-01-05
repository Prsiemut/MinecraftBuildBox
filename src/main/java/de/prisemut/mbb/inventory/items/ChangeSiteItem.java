package de.prisemut.mbb.inventory.items;

import de.prisemut.mbb.inventory.InteractiveInventory;
import de.prisemut.mbb.inventory.InteractiveItem;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@NoArgsConstructor
public class ChangeSiteItem implements InteractiveItem {

    private boolean back = false;

    public ChangeSiteItem(boolean back) {
        this.back = back;
    }

    @Override
    public void onClick(InteractiveInventory interactiveInventory, InventoryAction action) {
        int site = interactiveInventory.getSite();
        site = back ? site - 1 : site + 1;
        interactiveInventory.setSite(site);
        interactiveInventory.playClickSound();
    }

    @Override
    public ItemStack getItem(Player player) {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta itemMeta = item.getItemMeta();

        if (back) {
            itemMeta.setDisplayName("§7nächste Seite");
        } else {
            itemMeta.setDisplayName("§7vorherige Seite");
        }

        item.setItemMeta(itemMeta);

        return item;
    }

    @Override
    public String getName() {
        return back ? "prev_page_item" : "next_page_item";
    }
 }
