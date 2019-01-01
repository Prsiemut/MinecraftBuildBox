package de.prisemut.mbb.brush;

import de.prisemut.mbb.Messages;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Hashtable;

public class LineBrush implements BrushInterface{

    public static Hashtable<Player, Location> start = new Hashtable<>();
    public static Hashtable<Player, Location> end = new Hashtable<>();

    @Override
    public void build(Location spawnlocation, int size, Material pattern, Player player) {
        Messages messages = new Messages(player);
        Location point = start.get(player);
        Location point2 = end.get(player);
        Location vector = point2.clone().subtract(point);
        double lenght = 0;
        double distance = start.get(player).distance(end.get(player));

        if(start.get(player).getWorld().equals(end.get(player).getWorld())) {
            for(; lenght < distance; point.add(vector)) {
                player.getWorld().getBlockAt(point.getBlockX(), point.getBlockY(), point.getBlockZ()).setType(pattern);
            }
        } else {
            messages.sendMessage("The two points must be in one world!");
        }

    }

    @Override
    public String usage() {
        return null;
    }
}
