package de.prisemut.mbb.shiptool;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import java.util.ArrayList;

public class ShipManager {

    private Location location;

    public ShipManager(Location spawnlocation) {
        this.location = spawnlocation;
    }

    public void buildShip(World world) {
        ArrayList<Location> list = OldShip_Generator.perform(location);
        for(int i = 0; i < list.size(); i++) {
            world.getBlockAt(list.get(i)).setType(Material.EMERALD_BLOCK);
        }
    }

}
