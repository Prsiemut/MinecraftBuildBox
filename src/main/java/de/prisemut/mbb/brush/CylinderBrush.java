package de.prisemut.mbb.brush;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Map;

public class CylinderBrush implements BrushInterface{


    @Override
    public void build(Location spawnlocation, int size, Material pattern, Player player) {
        int cx = spawnlocation.getBlockX();
        int cy = spawnlocation.getBlockY();
        int cz = spawnlocation.getBlockZ();
        World world = spawnlocation.getWorld();
        int squared = size * size;

        for (int x = cx - size; x <= cx +size; x++) {
            for (int z = cz - size; z <= cz +size; z++) {
                if ((cx - x) * (cx - x) + (cz - z) * (cz - z) <= squared) {
                    world.getBlockAt(x, cy, z).setType(Material.STONE);
                }
            }
        }
    }

    @Override
    public String usage() {
        return "-";
    }
}
