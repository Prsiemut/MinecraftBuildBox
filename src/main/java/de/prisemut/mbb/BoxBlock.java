package de.prisemut.mbb;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BoxBlock {

    private Block block;
    private Material material;

    public BoxBlock(Block block, Material material) {
        this.block = block;
        this.material = material;
    }

    public int[] locations() {
        int[] locs = new int[2];
        locs[0] = block.getX();
        locs[1] = block.getY();
        locs[2] = block.getZ();
        return locs;
    }

    public String toString() {
        return block.getX() + ":" + block.getY() + ":" + block.getZ() + ":" + block.getTypeId() + ":" + block.getData();
    }

    public String[] getArrayString() {
        String[] string = new String[5];
        string[0] = String.valueOf(block.getX());
        string[1] = String.valueOf(block.getY());
        string[2] = String.valueOf(block.getZ());
        string[3] = String.valueOf(block.getTypeId());
        string[4] = String.valueOf(block.getData());
        string[5] = material.toString();
        return string;
    }

    public Location getBlockLocation() {
       return block.getLocation();
    }


}
