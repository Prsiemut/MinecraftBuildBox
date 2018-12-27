package de.prisemut.mbb;

import de.prisemut.mbb.commands.*;
import de.prisemut.mbb.interior.listener.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class MinecraftBuildingBox extends JavaPlugin {

    private static MinecraftBuildingBox instance;
    public static String prefix = "§8[§bMBB§8] §7";

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        System.out.println("[MBB] Loading...");

        /*
        Config
         */
        ConfigManager.setupConfig();
            Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);

        getCommand("mbb").setExecutor(new CommandHandler());
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.registerNewCommand("wcreate", new wcreate_command());
        commandHandler.registerNewCommand("wdelete", new wdelete_command());
        commandHandler.registerNewCommand("wtp", new wtp_command());
        commandHandler.registerNewCommand("wlist", new wlist_command());
        commandHandler.registerNewCommand("mi", new mi_command());


        File file = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/schematics/");
        file.mkdirs();



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
