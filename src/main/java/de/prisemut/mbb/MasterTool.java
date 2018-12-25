package de.prisemut.mbb;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Hashtable;

public class MasterTool implements Listener {

    public static Hashtable<Player, Location> location1 = new Hashtable<Player, Location>();
    public static Hashtable<Player, Location> location2 = new Hashtable<Player, Location>();
    private Player player;

    public MasterTool(Player player) {
        this.player = player;
    }

    public void setLocation1(Location location) {
        if(location1.contains(player)) {
            location1.clear();
            location1.put(player, location);
        } else {
            location1.put(player, location);
        }
    }

    public void setLocation2(Location location) {
        if(location2.contains(player)) {
            location2.clear();
            location2.put(player, location);
        } else {
            location2.put(player, location);
        }
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Messages m = new Messages(player);

        if(event.getItem().getType().equals(Material.BLAZE_ROD)) {
            if(event.getAction().equals(Action.LEFT_CLICK_BLOCK) && event.getClickedBlock() != null) {
                setLocation1(event.getClickedBlock().getLocation());
                m.sendMessage("Position [1] set!");
            }
            if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock() != null) {
                setLocation2(event.getClickedBlock().getLocation());
                m.sendMessage("Position [2] set!");
            }
        }
    }
}
