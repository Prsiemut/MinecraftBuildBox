package de.prisemut.mbb.brush;

import com.flowpowered.math.GenericMath;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BallBrush implements BrushInterface{


    @Override
    public void build(Location targetBlock, int size, Material pattern, Player player) {
        double brushSize = size;
        double brushSizeSquared = brushSize * brushSize;

        int tx = targetBlock.getBlockX();
        int ty = targetBlock.getBlockY();
        int tz = targetBlock.getBlockZ();
        int minx = GenericMath.floor(targetBlock.getBlockX() - brushSize);
        int maxx = GenericMath.floor(targetBlock.getBlockX() + brushSize) + 1;
        int miny = Math.max(GenericMath.floor(targetBlock.getBlockY() - brushSize), 0);
        int maxy = Math.min(GenericMath.floor(targetBlock.getBlockY() + brushSize) + 1, player.getWorld().getMaxHeight());
        int minz = GenericMath.floor(targetBlock.getBlockZ() - brushSize);
        int maxz = GenericMath.floor(targetBlock.getBlockZ() + brushSize) + 1;

        for (int x = maxx; x >= minx; x--) {
            double xs = (tx - x) * (tx - x);
            for (int y = maxy; y >= miny; y--) {
                double ys = (ty - y) * (ty - y);
                for (int z = maxz; z >= minz; z--) {
                    double zs = (tz - z) * (tz - z);
                    if (xs + ys + zs < brushSizeSquared) {
                        player.getWorld().getBlockAt(x, y, z).setType(pattern);
                    }
                }
            }
        }
    }

    @Override
    public String usage() {
        return null;
    }
}
