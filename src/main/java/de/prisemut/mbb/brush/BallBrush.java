package de.prisemut.mbb.brush;

import com.flowpowered.math.GenericMath;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BallBrush implements BrushInterface{


    @Override
    public void build(Location centerBlock, int radius, Material pattern, Player player) {
        boolean hollow = true;
        int bx = centerBlock.getBlockX();
        int by = centerBlock.getBlockY();
        int bz = centerBlock.getBlockZ();

        for(int x = bx - radius; x <= bx + radius; x++) {
            for(int y = by - radius; y <= by + radius; y++) {
                for(int z = bz - radius; z <= bz + radius; z++) {

                    double distance = ((bx-x) * (bx-x) + ((bz-z) * (bz-z)) + ((by-y) * (by-y)));

                    if(distance < radius * radius && !(hollow && distance < ((radius - 1) * (radius - 1)))) {

                        Location l = new Location(centerBlock.getWorld(), x, y, z);
                        player.getWorld().getBlockAt(l).setType(pattern);
                    }
                }
            }
        }
    }

    @Override
    public String usage() {
        return "s";
    }
}
