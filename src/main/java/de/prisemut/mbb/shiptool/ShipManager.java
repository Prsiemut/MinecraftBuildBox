package de.prisemut.mbb.shiptool;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class ShipManager {

    private ShipTypes shipTypes;
    private Location location;

    public ShipManager(ShipTypes types, Location spawnlocation) {
        this.shipTypes = types;
        this.location = spawnlocation;
    }

    public void buildShip(World world) {
        switch (shipTypes) {
            case OLD_PIRAT:
                for(int i = 0; i < OldShip_Generator.perform(location).size(); i++) {
                    world.getBlockAt(OldShip_Generator.perform(location).get(i)).setType(Material.EMERALD_BLOCK);
                }
                break;
            case OLD_WARSHIP:
                for(int i = 0; i < OldShip_Generator.perform(location).size(); i++) {
                    world.getBlockAt(OldShip_Generator.perform(location).get(i)).setType(Material.EMERALD_BLOCK);
                }
                break;
            case OLD_CONTAINER:
                for(int i = 0; i < OldShip_Generator.perform(location).size(); i++) {
                    world.getBlockAt(OldShip_Generator.perform(location).get(i)).setType(Material.EMERALD_BLOCK);
                }
                break;
            case MODER_WARSHIP:
                break;
            case MODERN_CONTAINER:
                break;
            default:
                break;
        }
    }

}
