package de.prisemut.mbb.brush;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public interface BrushInterface {

    void build(Location spawnlocation, int size, Material pattern, Player player);

    String usage();
}
