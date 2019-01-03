package de.prisemut.mbb;



public class Config {

    public static void setup() {
        MinecraftBuildingBox.getInstance().getConfig().options().copyDefaults(true);
        MinecraftBuildingBox.getInstance().getConfig().options().copyHeader(true);
        MinecraftBuildingBox.getInstance().saveDefaultConfig();
    }

    public static String getPrefix() {
        return MinecraftBuildingBox.getInstance().getConfig().getString("main.prefix");
    }
}
