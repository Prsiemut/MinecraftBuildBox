package de.prisemut.mbb;

import de.prisemut.mbb.commands.CommandHandler;
import de.prisemut.mbb.commands.wcreate_command;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftBuildingBox extends JavaPlugin {

    private static MinecraftBuildingBox instance;
    public static String prefix = "§8[§bMBB§8] ";

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        System.out.println("[MBB] Loading...");

        /*
        Config
         */
        ConfigManager.setupConfig();

        getCommand("mbb").setExecutor(new CommandHandler());
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.registerNewCommmand("wcreate", new wcreate_command());

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
