package de.prisemut.mbb;

import net.royawesome.jlibnoise.module.combiner.Min;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public static void setup() {
        FileConfiguration configuration = MinecraftBuildingBox.getInstance().getConfig();

        MinecraftBuildingBox.getInstance().reloadConfig();

        configuration.options().header("DiscordServer => https://discord.gg/UqTas3K");
        configuration.addDefault("MinecraftBuildingBox.brush.max-Size", 5);
        configuration.addDefault("MinecraftBuildingBox.world-creator.creator", "mf");
        configuration.addDefault("MinecraftBuildingBox.world-creator.creator", "mf+");
        configuration.addDefault("MinecraftBuildingBox.world-creator.creator", "cwc");
        configuration.addDefault("MinecraftBuildingBox.licences.structure-generator", "null");
    }

}
