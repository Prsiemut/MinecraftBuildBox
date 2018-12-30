package de.prisemut.mbb.brush.listener;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.brush.BrushManager;
import de.prisemut.mbb.brush.BrushTypes;
import de.prisemut.mbb.commands.BrushCommand;
import de.prisemut.mbb.math.Cuboid;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.Hash;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Hashtable;
import java.util.List;

public class BrushListener implements Listener {


    public static Hashtable<Player, Location> pos1 = new Hashtable<Player, Location>();
    public static Hashtable<Player, Location> pos2 = new Hashtable<Player, Location>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Messages messages = new Messages(player);

        if (event.getItem() != null) {
            if (event.getItem().getType() == Material.BLAZE_ROD && BrushCommand.edit.containsKey(player)) {
                if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (event.getClickedBlock() != null) {

                        BrushManager bm = new BrushManager();

                        if (BrushCommand.edit.get(player).equals(BrushTypes.CUBE_BRUSH)) {
                            bm.runBrush("cube", event.getClickedBlock().getLocation(), BrushCommand.editSize.get(player), Material.STONE, player);
                        } else  if(BrushCommand.edit.get(player).equals(BrushTypes.CUBE)) {
                            pos2.put(player, event.getClickedBlock().getLocation());
                            messages.sendMessage("Position 2 set!");
                        } else if(BrushCommand.edit.get(player).equals(BrushTypes.BALL_BRUSH)) {
                            bm.runBrush("ball", event.getClickedBlock().getLocation(), BrushCommand.editSize.get(player), Material.STONE, player);
                        }
                    } else {
                        messages.sendMessage("Please click on a block!");
                    }
                } else if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    if(BrushCommand.edit.get(player).equals(BrushTypes.CUBE)) {
                        pos1.put(player, event.getClickedBlock().getLocation());
                        messages.sendMessage("Postition 1 set!");
                    }
                }
            }
        }
    }
}
