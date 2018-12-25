package de.prisemut.mbb.interior.listener;

import de.prisemut.mbb.MinecraftBuildingBox;
import de.prisemut.mbb.interior.InteriorInventory;
import de.prisemut.mbb.interior.SchematicManager;
import org.apache.logging.log4j.core.Core;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InventoryListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getName().equals("§4Manuell §7[§41§7]") || event.getInventory().getName().equals("§4Manuell §7[§42§7]")) {
            event.setCancelled(true);

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§4Next side ->")) {
                player.closeInventory();
                InteriorInventory.buildNextSide(player);
            } else
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§4<- Back")) {
                player.closeInventory();
                InteriorInventory.buildInventory(player);
            } else
            if (event.getCurrentItem().getItemMeta().getDisplayName().contains(".schematic")) {

                player.closeInventory();
                player.getInventory().addItem(InteriorInventory
                        .createItem(event.getCurrentItem().getItemMeta().getDisplayName(), Material.BOOK));
                player.sendMessage(MinecraftBuildingBox.prefix + "Bounded schematic on a new item!");

            } else {
                player.closeInventory();
                player.sendMessage(MinecraftBuildingBox.prefix + "§4Please select an schematic file!");
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() != null) {
            if (event.getItem().getType() == Material.BOOK
                    && event.getItem().getItemMeta().getDisplayName().contains(".schematic")) {
                if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (event.getClickedBlock() != null) {

                        if (getDirection(player) == 0xC) {
                            SchematicManager.pasteSchematic270(event.getClickedBlock().getLocation().add(0, 1, 1),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);
                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else if (getDirection(player) == 0xE) {
                            SchematicManager.pasteSchematic270(event.getClickedBlock().getLocation().add(0, 1, 1),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);
                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else if (getDirection(player) == 0x0) {
                            SchematicManager.pasteSchematic(event.getClickedBlock().getLocation().add(-1, 1, 0),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);
                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else if (getDirection(player) == 0x2) {
                            SchematicManager.pasteSchematic(event.getClickedBlock().getLocation().add(-1, 1, 0),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);
                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else if (getDirection(player) == 0x4) {
                            SchematicManager.pasteSchematic90(event.getClickedBlock().getLocation().add(0, 1, -1),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);
                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else if (getDirection(player) == 0x6) {
                            SchematicManager.pasteSchematic90(event.getClickedBlock().getLocation().add(0, 1, -1),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);
                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else if (getDirection(player) == 0x8) {
                            SchematicManager.pasteSchematic180(event.getClickedBlock().getLocation().add(1, 1, 0),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);
                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else if (getDirection(player) == 0xA) {
                            SchematicManager.pasteSchematic180(event.getClickedBlock().getLocation().add(1, 1, 0),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);
                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else if (getDirection(player) == 0xC) {
                            SchematicManager.pasteSchematic90(event.getClickedBlock().getLocation().add(0, 1, 1),
                                    event.getItem().getItemMeta().getDisplayName().replaceAll(".schematic", ""), player);

                            player.sendMessage(MinecraftBuildingBox.prefix + "Pasted schematic successfully!");
                        } else {
                            player.sendMessage(MinecraftBuildingBox.prefix + "ERROR!");
                        }
                    }
                } else {
                    player.sendMessage(MinecraftBuildingBox.prefix + "Please click on a block!");
                }
            }
        }

    }

    public byte getDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 90) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5) {
            return 0xC;
        } else if (22.5 <= rotation && rotation < 67.5) {
            return 0xE;
        } else if (67.5 <= rotation && rotation < 112.5) {
            return 0x0;
        } else if (112.5 <= rotation && rotation < 157.5) {
            return 0x2;
        } else if (157.5 <= rotation && rotation < 202.5) {
            return 0x4;
        } else if (202.5 <= rotation && rotation < 247.5) {
            return 0x6;
        } else if (247.5 <= rotation && rotation < 292.5) {
            return 0x8;
        } else if (292.5 <= rotation && rotation < 337.5) {
            return 0xA;
        } else if (337.5 <= rotation && rotation < 360.0) {
            return 0xC;
        } else {
            return (Byte) null;
        }
    }
}
