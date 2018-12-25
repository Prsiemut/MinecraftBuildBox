package de.prisemut.mbb;

public class ConfigManager {

    public static void setupConfig() {
        MinecraftBuildingBox.getInstance().getConfig().options().copyDefaults(true);
    }

    public static int getMaxBrushSize(){
        return MinecraftBuildingBox.getInstance().getConfig().getInt("brush.maxSize");
    }

}
