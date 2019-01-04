package de.prisemut.mbb.shiptool;

import de.prisemut.mbb.MinecraftBuildingBox;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class ShipManager {

    private ShipTypes types;
    private Player player;
    private Location location;

    public ShipManager(ShipTypes shipTypes, Player player, Location location) {
        this.types = shipTypes;
        this.player = player;
        this.location = location;
    }

    public void createShip() {
        switch (types) {
            case OLD_PIRAT:
                try {
                    Schematic schematic = ShipPaster.loadSchematic(new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/ships/", "oldp.schematic"));
                    ShipPaster.pasteSchematic(player.getWorld(), location, schematic);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case OLD:
                try {
                    Schematic schematic = ShipPaster.loadSchematic(new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/ships/", "old.schematic"));
                    ShipPaster.pasteSchematic(player.getWorld(), location, schematic);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case MODERN_WARSHIP:
                try {
                    Schematic schematic = ShipPaster.loadSchematic(new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/ships/","modernw.schematic"));
                    ShipPaster.pasteSchematic(player.getWorld(), location, schematic);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

}
