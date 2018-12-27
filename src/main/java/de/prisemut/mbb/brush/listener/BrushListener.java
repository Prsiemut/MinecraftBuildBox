package de.prisemut.mbb.brush.listener;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.brush.BrushManager;
import de.prisemut.mbb.brush.BrushTypes;
import de.prisemut.mbb.commands.BrushCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class BrushListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Messages messages = new Messages(player);

        if(event.getItem().getType().equals(Material.BLAZE_ROD) && BrushCommand.edit.containsKey(player) && event.getItem() != null) {
            if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if(event.getClickedBlock() != null) {

                    BrushManager bm = new BrushManager();

                    if(BrushCommand.edit.get(player).equals(BrushTypes.CUBE_BRUSH)) {
                        bm.runBrush("cube", event.getClickedBlock().getLocation(), BrushCommand.editSize.get(player), Material.STONE, player);
                    }
                    
                } else {
                    messages.sendMessage("Please click on a block!");
                }
            }
        }
    }

}
