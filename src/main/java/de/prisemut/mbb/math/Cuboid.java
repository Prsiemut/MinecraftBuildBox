package de.prisemut.mbb.math;

import de.prisemut.mbb.Messages;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import javax.tools.DocumentationTool;
import java.util.ArrayList;
import java.util.Iterator;

public class Cuboid implements Iterable<Block>, Cloneable{

    private Player player;
    private String worldName;
    private int x1, y1, z1;
    private int x2, y2, z2;

    public Cuboid(Location l1, Location l2, Player player) {
        Messages m = new Messages(player);
        if(l1.getWorld().equals(l2.getWorld())) {
            this.player = player;
            this.worldName = l1.getWorld().getName();

            this.x1 = Math.min(l1.getBlockX(), l2.getBlockX());
            this.y1 = Math.min(l1.getBlockY(), l2.getBlockY());
            this.z1 = Math.min(l1.getBlockZ(), l2.getBlockZ());

            this.x2 = Math.max(l1.getBlockX(), l2.getBlockX());
            this.y2 = Math.max(l1.getBlockY(), l2.getBlockY());
            this.z2 = Math.max(l1.getBlockZ(), l2.getBlockZ());

        } else {
            m.sendMessage("Points must be in one world!");
            System.out.println("[MBB] Error while creating cube!");
        }
    }
    public World getWorld() {
        World w = Bukkit.getWorld(worldName);
        return w;
    }

    public void fillCube(Material material) {
        for(int i = 0; i < getAllBlocks().size(); i++) {
            getAllBlocks().get(i).setType(material);
        }
    }

    public ArrayList<Block> getAllBlocks() {
        Iterator<Block> blockI = this.iterator();
        ArrayList<Block> list = new ArrayList<Block>();
        while (blockI.hasNext()) {
            list.add(blockI.next());
        }
        return list;
    }


    public Iterator<Block> iterator() {
        return new CuboidIterator(getWorld(), this.x1, this.y1, this.z1, this.x2, this.y2, this.z2);
    }

    public class CuboidIterator implements Iterator<Block> {

        private World world;
        private int baseX, baseY, baseZ;
        private int x, y, z;
        private int sizeX, sizeY, sizeZ;

        public CuboidIterator(World world, int x1, int y1, int z1, int x2, int y2, int z2){
            this.world = world;

            this.baseX = x1;
            this.baseY = y1;
            this.baseZ = z1;

            this.sizeX = Math.abs(x2 - x1) +1;
            this.sizeY = Math.abs(y2 - y1) +1;
            this.sizeZ = Math.abs(z2 - z1) +1;

            this.x = this.y = this.z = 0;
        }

        public boolean hasNext() {
            return this.x < this.sizeX && this.y < this.sizeY && this.z < this.sizeZ;
        }

        public Block next() {
            Block block = this.world.getBlockAt(this.baseX + this.x, this.baseY + y, this.baseZ + z);
            if(++y >= this.sizeX) {
                this.x = 0;
                if(++this.y >= this.sizeY) {
                    this.y = 0;
                    ++this.z;
                }
            }
            return block;
        }

        public void remove() {

        }
    }

}
