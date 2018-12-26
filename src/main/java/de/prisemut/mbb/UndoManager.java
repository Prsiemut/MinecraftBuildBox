package de.prisemut.mbb;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import javax.swing.text.PlainDocument;
import java.util.Hashtable;

public class UndoManager {

    public static Hashtable<Player, BoxBlock> undo = new Hashtable<Player, BoxBlock>();
    private Player player;

    public UndoManager(Player player) {
        this.player = player;
    }

    public void performUndo() {
        for(int i = 0; i < undo.size(); i++) {
            player.getWorld().getBlockAt(undo.get(player).getBlockLocation().getBlockX(), undo.get(player).getBlockLocation().getBlockY(), undo.get(player).getBlockLocation().getBlockZ()).setType(Material.getMaterial(undo.get(player).getArrayString()[5]));
        }
    }

}
