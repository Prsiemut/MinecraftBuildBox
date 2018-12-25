package de.prisemut.mbb.world.CoustomChunkGenerator;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MFP_Generator extends ChunkGenerator {

    private boolean air = false;

    public MFP_Generator(boolean air) {
        this.air = air;
    }

    @Override
    public byte[][] generateBlockSections(World world, Random random, int x, int z, BiomeGrid biomes) {
        byte[][] result = new byte[world.getMaxHeight() / 16][];
        result[0] = new byte[4096];
        Arrays.fill(result[0], 0, 256, (byte) 7); //Bedrock layer
        Arrays.fill(result[0], 256, 512, (byte) 35); //Wool layer
        return result;
    }

    @Override
    public Location getFixedSpawnLocation(World world, Random random) {
        if (this.air)
            return new Location(world, 0.5, 65, 0.5);
        else
            return new Location(world, 0, 1, 0);
    }


    @Override
    public boolean canSpawn(World world, int x, int z) {
        return true;
    }

    public boolean isAir() {
        return air;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.<BlockPopulator>asList(new FlatBlockPopulator());
    }

}
