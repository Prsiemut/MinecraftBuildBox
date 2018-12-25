package de.prisemut.mbb.interior;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import de.prisemut.mbb.MinecraftBuildingBox;
import net.royawesome.jlibnoise.module.combiner.Min;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;

public class SchematicManager {

    public static void pasteSchematic90(Location loc, String name, Player player) {
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        File schem = new File(
                MinecraftBuildingBox.getInstance().getDataFolder() + File.separator + "/schematics/" + name + ".schematic");
        EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory()
                .getEditSession(new BukkitWorld(loc.getWorld()), 1000000000);
        try {
            CuboidClipboard cp = MCEditSchematicFormat.getFormat(schem).load(schem);
            cp.rotate2D(90);
            cp.paste(session, new Vector(loc.getX(), loc.getY(), loc.getZ()), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pasteSchematic(Location loc, String name, Player player) {
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        File schem = new File(
                MinecraftBuildingBox.getInstance().getDataFolder() + File.separator + "/schematics/" + name + ".schematic");
        EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory()
                .getEditSession(new BukkitWorld(loc.getWorld()), 1000000000);
        try {
            CuboidClipboard cp = MCEditSchematicFormat.getFormat(schem).load(schem);
            cp.rotate2D(0);
            cp.paste(session, new Vector(loc.getX(), loc.getY(), loc.getZ()), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void pasteSchematic180(Location loc, String name, Player player) {
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        File schem = new File(
                MinecraftBuildingBox.getInstance().getDataFolder() + File.separator + "/schematics/" + name + ".schematic");
        EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory()
                .getEditSession(new BukkitWorld(loc.getWorld()), 1000000000);
        try {
            CuboidClipboard cp = MCEditSchematicFormat.getFormat(schem).load(schem);
            cp.rotate2D(180);
            cp.paste(session, new Vector(loc.getX(), loc.getY(), loc.getZ()), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pasteSchematic270(Location loc, String name, Player player) {
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        File schem = new File(
                MinecraftBuildingBox.getInstance().getDataFolder() + File.separator + "/schematics/" + name + ".schematic");
        EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory()
                .getEditSession(new BukkitWorld(loc.getWorld()), 1000000000);

        try {
            CuboidClipboard cp = MCEditSchematicFormat.getFormat(schem).load(schem);
            cp.rotate2D(270);
            cp.paste(session, new Vector(loc.getX(), loc.getY(), loc.getZ()), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
