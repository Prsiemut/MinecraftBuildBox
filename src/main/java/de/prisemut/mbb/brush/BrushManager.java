package de.prisemut.mbb.brush;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.Hash;
import org.bukkit.entity.Player;

import java.util.Hashtable;

public class BrushManager {

    public static Hashtable<String, BrushInterface> regestry = new Hashtable<String, BrushInterface>();
    public static Hashtable<BrushInterface, String> usage = new Hashtable<BrushInterface, String>();

    public void BrushManager() {

    }

    public void registerBrush(BrushInterface brushInterface, String name) {
        regestry.put(name, brushInterface);
        usage.put(brushInterface, getExecutor(name).usage());
    }

    public BrushInterface getExecutor(String brush) {
        return regestry.get(brush);
    }

    public void runBrush(String brush, Location location, int size, Material material, Player player) {
        getExecutor(brush).build(location, size, material, player);
    }
}
