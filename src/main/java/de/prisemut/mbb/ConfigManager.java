package de.prisemut.mbb;

public class ConfigManager {

    public static void setupConfig() {
        MinecraftBuildingBox.getInstance().getConfig().options().copyDefaults(true);
    }

    public static int getMaxBrushSize(){
        return MinecraftBuildingBox.getInstance().getConfig().getInt("brush.maxSize");
    }

    public static boolean interiorIsEnable() {
        return MinecraftBuildingBox.getInstance().getConfig().getBoolean("main.enable-interior");
    }

}
