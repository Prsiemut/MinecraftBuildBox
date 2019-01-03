package de.prisemut.mbb;

import org.bukkit.entity.Player;

import org.bukkit.*;

public class Messages {

    public static String prefix = "§7[§bMBB§7] ";
    private Player player;

    public Messages(Player player) {
        this.player = player;
    }

    public void sendMessage(String msg) {
        player.sendMessage(prefix + msg);
    }

    public void sendServerMessage(String msg){
         Bukkit.broadcastMessage(msg);
    }


}
