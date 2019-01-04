package de.prisemut.mbb.shiptool;

import org.bukkit.Location;
import org.bukkit.entity.Player;

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
                    ShipPaster.pasteSchematic(player.getWorld(), location, ShipPaster.loadSchematic("oldp.schematic"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case OLD:
                try {
                    ShipPaster.pasteSchematic(player.getWorld(), location, ShipPaster.loadSchematic("old.schematic"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case MODERN_WARSHIP:
                try {
                    ShipPaster.pasteSchematic(player.getWorld(), location, ShipPaster.loadSchematic("modernw.schematic"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

}
