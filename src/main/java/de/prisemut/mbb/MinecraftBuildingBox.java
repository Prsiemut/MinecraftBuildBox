package de.prisemut.mbb;

import de.prisemut.mbb.brush.BallBrush;
import de.prisemut.mbb.brush.BrushManager;
import de.prisemut.mbb.brush.CubeBrush;
import de.prisemut.mbb.brush.LineBrush;
import de.prisemut.mbb.brush.listener.BrushListener;
import de.prisemut.mbb.commands.*;
import de.prisemut.mbb.interior.listener.InventoryListener;
import de.prisemut.mbb.inventory.InventoryManager;
import de.prisemut.mbb.server.tcp.TCPClient;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.spongepowered.api.event.command.TabCompleteEvent;

import java.io.File;
import java.io.IOException;

/**
  @author Prisemut
 */
public class MinecraftBuildingBox extends JavaPlugin {

    private static MinecraftBuildingBox instance;
    public static String prefix = "§7[§bMBB§7] ";
    TCPClient tcpClient = new TCPClient();

    @Getter public InventoryManager inventoryManager;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        System.out.println("[MBB] Loading...");
        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        /*
        File part
         */
        File folder = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/ships/");
        if(!folder.exists()) {
            folder.mkdirs();
            console.sendMessage(ChatColor.WHITE + "[MBB] " + ChatColor.GREEN + "Created ship folder!");
        }

        File tcpFolder = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/tcp/");
        if(!tcpFolder.exists()) {
            tcpFolder.mkdirs();
            console.sendMessage(ChatColor.WHITE + "[MBB] " + ChatColor.GREEN + "Created tcp folder!");
        }

        //Check if File exists -> enable the TCP Client
        File f = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/tcp/TCP.Client");
        if(f.exists()) {
            console.sendMessage(ChatColor.WHITE + "[MBB] " + ChatColor.GREEN + "Enabling TCP Client...");
            tcpClient.Connect();
        }

        File file = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/schematics/");
        if(!file.exists()) {
            file.mkdirs();
            console.sendMessage(ChatColor.WHITE + "[MBB] " + ChatColor.GREEN + "Created schemtic folder!");
        }

        console.sendMessage(ChatColor.WHITE + "[MBB] Loaded all files/created all files!");



        /*
        Config
         */
        Config.setup();
        console.sendMessage(ChatColor.WHITE + "[MBB] Loaded configurations!");

        /*
        Listener
         */
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new BrushListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        console.sendMessage(ChatColor.WHITE + "[MBB] Loaded all listener!");

        /*
        Brushes
         */
        BrushManager brushManager = new BrushManager();
        brushManager.registerBrush(new CubeBrush(), "cube");
        brushManager.registerBrush(new BallBrush(), "ball");
        brushManager.registerBrush(new LineBrush(), "line");
        console.sendMessage(ChatColor.WHITE + "[MBB] Loaded 3 Brushes!");

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
        commandHandler.registerNewCommand("debug", new debug_command());
        console.sendMessage(ChatColor.WHITE + "[MBB] Loaded 1 main command and 8 subcommands.");




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
