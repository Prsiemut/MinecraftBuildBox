package de.prisemut.mbb.world.CoustomChunkGenerator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

public class FlatBlockPopulator extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                chunk.getBlock(x, 0, z).setBiome(Biome.FOREST);
            }
        }
    }

}

