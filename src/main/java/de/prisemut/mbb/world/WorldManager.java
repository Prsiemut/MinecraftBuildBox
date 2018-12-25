package de.prisemut.mbb.world;

import de.prisemut.mbb.world.CoustomChunkGenerator.Coustom_Generator;
import de.prisemut.mbb.world.CoustomChunkGenerator.MFP_Generator;
import de.prisemut.mbb.world.CoustomChunkGenerator.MF_Generator;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

import java.io.File;
import java.io.IOException;

public class WorldManager {

    /*
    Options:
    Name:
    Type: FLAT or NORMAL or MF or MF+ or -cwc
    [= -ccl] CoustomWorldkCreator: 1-5 Arguments]

    /mbb wcreate [name] [Type]
    or
    /mbb wcreate -cwc [layer1] [layer2]

     */


    private WorldTypes types;
    private String worldname;
    private int l1;
    private int l2;

    public WorldManager(String name, WorldTypes types) {
        this.worldname = name;
        this.types = types;
    }
    public WorldManager(String name, int layer1, int layer2) {
        this.worldname = name;
        this.l1 = layer1;
        this.l2 = layer2;
    }

    public static void deleteWorld(String worldname) {
        File file = Bukkit.getWorld(worldname).getWorldFolder();

        Bukkit.unloadWorld(file.getName(), false);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createCoustomWorld() {
            Coustom_Generator cg = new Coustom_Generator(l1, l2);
            World world = new WorldCreator(worldname)
                    .environment(World.Environment.NORMAL)
                    .generator(cg)
                    .createWorld();
    }

    public void createWorld() {
        if(types.equals(WorldTypes.FLAT)) {
            World world = new WorldCreator(worldname)
                    .environment(World.Environment.NORMAL)
                    .type(WorldType.FLAT)
                    .createWorld();
        }else if(types.equals(WorldTypes.MF)) {
            World world = new WorldCreator(worldname)
                    .environment(World.Environment.NORMAL)
                    .generator(new MF_Generator(true))
                    .createWorld();
        }else if(types.equals(WorldTypes.MFP)) {
            World world = new WorldCreator(worldname)
                    .environment(World.Environment.NORMAL)
                    .generator(new MFP_Generator(true))
                    .createWorld();
        }

    }
}
