package de.prisemut.mbb.debug;

import de.prisemut.mbb.MinecraftBuildingBox;
import net.royawesome.jlibnoise.module.combiner.Min;
import org.bukkit.entity.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class DebugManager {

    public static Hashtable<Player, String> debug = new Hashtable<Player, String>();

    public static void debug(Player player, String string) {
        debug.put(player, string);
    }

    public static void finishDebug(Player player) {
        String newline = System.getProperty("line.separator");
        File file = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/debug/");
        if(file.exists()) {
        }else{
            file.mkdirs();
        }

        File debugfile = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/debug/debugfile"+player.getName()+".txt");
        if(debugfile.exists()) {
            player.sendMessage(MinecraftBuildingBox.prefix + "Debuging failed! You already got an debugfile! System will now create a new file for you!");
            debugfile.delete();
            try {
                debugfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                debugfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(debugfile));
            for(int i = 0; i < debug.size(); i++) {
                bufferedWriter.write(debug.get(i));
                bufferedWriter.write(newline);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}