package de.prisemut.mbb;

import de.prisemut.mbb.brush.BrushTypes;
import de.prisemut.mbb.commands.BrushCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        BrushCommand.edit.put(player, BrushTypes.CUBE);
    }

}
