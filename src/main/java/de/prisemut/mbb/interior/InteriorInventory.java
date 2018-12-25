package de.prisemut.mbb.interior;

import de.prisemut.mbb.MinecraftBuildingBox;
import org.apache.logging.log4j.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class InteriorInventory {

    public static int side = 1;
    public static int nextside = 1;

    public static void buildInventory(Player player) {
        try {

            Inventory inventory = Bukkit.createInventory(null, 54, "§4Manuell §7[§41§7]");

            File dir = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/schematics");
            File[] files = dir.listFiles();

            if (files.length <= 52) {
                for (int i = 0; i < files.length; i++) {
                    inventory.setItem(i, createItem(files[i].getName(), Material.BOOK));
                }
            }else{
                for (int i = 0; i < 53; i++) {
                    inventory.setItem(i, createItem(files[i].getName(), Material.BOOK));
                }
            }
            inventory.setItem(53, createItem("§4Next side ->", Material.ARROW));

            player.openInventory(inventory);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void buildNextSide(Player player) {
        Inventory inventory2 = Bukkit.createInventory(null, 54, "§4Manuell §7[§42§7]");

        File dir = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/schematics");
        File[] files = dir.listFiles();

        for (int i = 0; i < files.length - 53; i++) {
            inventory2.setItem(i, createItem(files[i].getName(), Material.BOOK));
        }
        inventory2.setItem(45, createItem("§4<- Back", Material.ARROW));

        player.openInventory(inventory2);

    }

    public static ItemStack createItem(String displayname, Material mat) {
        ItemStack is = new ItemStack(mat);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(displayname);
        is.setItemMeta(im);
        return is;
    }

}
