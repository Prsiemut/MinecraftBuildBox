package de.prisemut.mbb.shiptool;

import org.bukkit.Location;
import org.bukkit.entity.Player;

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
                ShipPaster.pasteSchematic(player.getWorld(), location, ShipPaster.loadSchematic("oldp.schematic"));
                break;
            case OLD:
                ShipPaster.pasteSchematic(player.getWorld(), location, ShipPaster.loadSchematic("old.schematic"));
                break;
            case MODERN_WARSHIP:
                ShipPaster.pasteSchematic(player.getWorld(), location, ShipPaster.loadSchematic("modernw.schematic"));
                break;
            default:
                break;
        }
    }

}
