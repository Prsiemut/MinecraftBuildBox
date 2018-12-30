package de.prisemut.mbb;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Wolf;

import java.util.ArrayList;

public class BoxPerformer {

    private World world;
    private BoxPattern pattern;

    public BoxPerformer(World world, BoxPattern pattern) {
    }

    public void setBlock(Location location) {
        world.getBlockAt(location).setType(pattern.getMaterial());
    }

    public void setBlock(Location location, Material material) {
        world.getBlockAt(location).setType(pattern.getMaterial());
    }

    public Block getBlock() {
        return null;
    }

    public void performFromList(ArrayList<Material> materialList, ArrayList<Location> locations) {
        for(int i = 0; i < materialList.size(); i++) {
            setBlock(locations.get(i), materialList.get(i));
        }
    }

    public void performFromKIData() {

    }
}
