package de.prisemut.mbb;

import de.prisemut.mbb.brush.BallBrush;
import de.prisemut.mbb.brush.BrushManager;
import de.prisemut.mbb.brush.CubeBrush;
import de.prisemut.mbb.brush.CylinderBrush;
import de.prisemut.mbb.brush.listener.BrushListener;
import de.prisemut.mbb.commands.*;
import de.prisemut.mbb.interior.listener.InventoryListener;
import de.prisemut.mbb.server.tcp.*;
import net.royawesome.jlibnoise.module.combiner.Min;
import org.bukkit.Bukkit;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class MinecraftBuildingBox extends JavaPlugin {

    private static MinecraftBuildingBox instance;
    public static String prefix = "§8[§bMBB§8] §7";
    TCPClient tcpClient = new TCPClient();
    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        System.out.println("[MBB] Loading...");

        //Check if File exists -> enable the TCP Client
        File f = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/TCP.Client");
        if(f.exists()){
            System.out.println("Enabling TCP Client...");

            tcpClient.Connect();
        }

        /*
        Config
         */

        /*
        Listener
         */
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new BrushListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        /*
        Brushes
         */
        BrushManager brushManager = new BrushManager();
        brushManager.registerBrush(new CubeBrush(), "cube");
        brushManager.registerBrush(new CylinderBrush(), "cylinder");
        brushManager.registerBrush(new BallBrush(), "ball");

        /*
        Commands
         */
        getCommand("mbb").setExecutor(new CommandHandler());
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.registerNewCommand("mi", new mi_command());
        commandHandler.registerNewCommand("br", new BrushCommand());
        commandHandler.registerNewCommand("fill", new fill_command());
        commandHandler.registerNewCommand("world", new world_Command());
        commandHandler.registerNewCommand("BS", new buildServer_command());
        commandHandler.registerNewCommand("ship", new ship_command());

        File file = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/schematics/");
        file.mkdirs();
        File file2 = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/hmaps/");
        file2.mkdirs();



    }

    @Override
    public void onDisable() {
        tcpClient.close();
        super.onDisable();
        System.out.println("[MBB] Disabling...");
    }

    public static MinecraftBuildingBox getInstance(){
        return instance;
    }
}
