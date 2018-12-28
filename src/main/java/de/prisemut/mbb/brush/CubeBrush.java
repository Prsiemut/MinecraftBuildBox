package de.prisemut.mbb.brush;

import de.prisemut.mbb.ConfigManager;
import de.prisemut.mbb.Messages;
import de.prisemut.mbb.math.Cuboid;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class CubeBrush implements BrushInterface {

    public void build(Location spawnlocation, int size, Material pattern, Player player) {
        Messages m = new Messages(player);

        if(size <= ConfigManager.getMaxBrushSize()) {
            if(size !=  0) {
                Location point1 = spawnlocation.add( 20, 0, 10);
                Location point2 = point1.add(20, 5, 30);
                Cuboid c = new Cuboid(point1, point2, player);
                c.fillCube(pattern);
                m.sendMessage("Successfully spawned "+ c.getBlocks().size() + " blocks!");
            }else{
                m.sendMessage("Brush size can`t be 0!");
            }
        }else{
            m.sendMessage(ConfigManager.getMaxBrushSize() + " is the maximum size for brush!");
        }
    }

    public String usage() {
        return "<material> <size>";
    }
}
