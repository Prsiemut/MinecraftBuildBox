package de.prisemut.mbb;

import org.bukkit.entity.Player;

public class Messages {

    private String prefix = "§8[§bMBB§8] §7";
    private Player player;

    public Messages(Player player) {
        this.player = player;
    }

    public void sendMessage(String msg) {
        player.sendMessage(prefix + msg);
    }


}
