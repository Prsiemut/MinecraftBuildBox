package de.prisemut.mbb.shiptool;

import org.bukkit.Location;

import java.util.ArrayList;

public class OldShip_Generator {

    public static ArrayList<Location> perform(Location spawnLocation) {
        ArrayList<Location> list = new ArrayList<>();
        /*
        Side 1
         */
        for(int i = 0; i < 9; i++) {
            list.add(spawnLocation.add(i, spawnLocation.getBlockY(), spawnLocation.getBlockZ()));
        }
        for(int i = 0; i < 6; i++) {
            list.add(spawnLocation.add(9 + i, spawnLocation.getBlockY() + 1, spawnLocation.getBlockZ()));
        }
        for(int i = 0; i < 4; i++) {
            list.add(spawnLocation.add(15 + i, spawnLocation.getBlockY() + 2, spawnLocation.getBlockZ()));
        }
        list.add(spawnLocation.add(20, spawnLocation.getBlockY() + 3, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(21, spawnLocation.getBlockY() + 4, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(21, spawnLocation.getBlockY() + 5, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(21, spawnLocation.getBlockY() + 6, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(22, spawnLocation.getBlockY() + 6, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(22, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(21, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(22, spawnLocation.getBlockY() + 8, spawnLocation.getBlockZ()));
        /*
        Side 2
         */
        for(int i = 0; i < 11; i++) {
            list.add(spawnLocation.add(-i, spawnLocation.getBlockY(), spawnLocation.getBlockZ()));
        }
        for(int i = 0; i < 3; i++) {
            list.add(spawnLocation.add(-11 - i, spawnLocation.getBlockY() + 1, spawnLocation.getBlockZ()));
        }
        list.add(spawnLocation.add(-13, spawnLocation.getBlockY() + 2, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(-14, spawnLocation.getBlockY() + 3, spawnLocation.getBlockZ()));
        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(-15 - i, spawnLocation.getBlockY() + 4, spawnLocation.getBlockZ()));
        }
        list.add(spawnLocation.add(-17, spawnLocation.getBlockY() + 5, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(-17, spawnLocation.getBlockY() + 6, spawnLocation.getBlockZ()));
        list.add(spawnLocation.add(-17, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ()));
        return list;
    }

}
