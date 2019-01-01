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


        /*
        Side 3 / 1
         */
        for(int i = 0; i < 4; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 1, spawnLocation.getBlockZ() + i));
        }

        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 2, spawnLocation.getBlockZ() + i));
        }

        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 3, spawnLocation.getBlockZ() + 6));
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 4, spawnLocation.getBlockZ() + 7));
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 5, spawnLocation.getBlockZ() + 7));
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 6, spawnLocation.getBlockZ() + 7));
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 7));

        for(int i = 0; i < 10; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 7));
        }

        for(int i = 0; i < 5; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + 10 + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 6));
        }

        for(int i = 0; i < 3; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + 15 + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 5));
        }

        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + 18 + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 4));
        }

        list.add(spawnLocation.add(spawnLocation.getBlockX() + 20, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 3));

        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + 20 + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 2));
        }

        list.add(spawnLocation.add(spawnLocation.getBlockX() + 22, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 1));

        /*
        Side 3 / 2
         */
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 7));

        for(int i = 0; i < 4; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() - i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 7));
        }

        for(int i = 0; i < 8; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() - 3 - i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 6));
        }

        for(int i = 0; i < 3; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() - 11 - i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 5));
        }

        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() - 14 - i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 4));
        }

        list.add(spawnLocation.add(spawnLocation.getBlockX() - 16, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 3));
        list.add(spawnLocation.add(spawnLocation.getBlockX() - 16, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 2));
        list.add(spawnLocation.add(spawnLocation.getBlockX() - 16, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 1));
        list.add(spawnLocation.add(spawnLocation.getBlockX() - 16, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ()));


        /*
        Side 4 / 1
         */

        for(int i = 0; i < 4; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 1, spawnLocation.getBlockZ() - i));
        }

        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 2, spawnLocation.getBlockZ() - i));
        }

        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 3, spawnLocation.getBlockZ() - 6));
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 4, spawnLocation.getBlockZ() - 7));
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 5, spawnLocation.getBlockZ() - 7));
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 6, spawnLocation.getBlockZ() - 7));
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() - 7));

        for(int i = 0; i < 10; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 7));
        }

        for(int i = 0; i < 5; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + 10 + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 6));
        }

        for(int i = 0; i < 3; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + 15 + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 5));
        }

        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + 18 + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 4));
        }

        list.add(spawnLocation.add(spawnLocation.getBlockX() + 20, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 3));

        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() + 20 + i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 2));
        }

        list.add(spawnLocation.add(spawnLocation.getBlockX() + 22, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 1));

        /*
        Side 4 / 2
         */
        list.add(spawnLocation.add(spawnLocation.getBlockX(), spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 7));

        for(int i = 0; i < 4; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() - i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 7));
        }

        for(int i = 0; i < 8; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() - 3 - i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 6));
        }

        for(int i = 0; i < 3; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() - 11 - i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 5));
        }

        for(int i = 0; i < 2; i++) {
            list.add(spawnLocation.add(spawnLocation.getBlockX() - 14 - i, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 4));
        }

        list.add(spawnLocation.add(spawnLocation.getBlockX() - 16, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 3));
        list.add(spawnLocation.add(spawnLocation.getBlockX() - 16, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 2));
        list.add(spawnLocation.add(spawnLocation.getBlockX() - 16, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ() + 1));
        list.add(spawnLocation.add(spawnLocation.getBlockX() - 16, spawnLocation.getBlockY() + 7, spawnLocation.getBlockZ()));


        return list;
    }

}
