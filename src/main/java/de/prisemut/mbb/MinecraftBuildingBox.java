package de.prisemut.mbb;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftBuildingBox extends JavaPlugin {

    private static MinecraftBuildingBox instance;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        System.out.println("[MBB] Loading...");

        /*
        Config
         */
        ConfigManager.setupConfig();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        System.out.println("[MBB] Disabling...");
    }

    public static MinecraftBuildingBox getInstance(){
        return instance;
    }
}
