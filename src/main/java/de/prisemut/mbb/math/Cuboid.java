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
import java.util.Map;

public class Cuboid implements Iterable<Block>, Cloneable{

    public static ArrayList<Location> loc1 = new ArrayList<Location>();
    public static ArrayList<Location> loc2 = new ArrayList<Location>();
    public Player player;

    private String worldName;
    private int X1, Z1, Y1;
    private int X2, Z2, Y2;

    public Cuboid(Location loc1, Location loc2, Player p) {
        if (loc1.getWorld().equals(loc2.getWorld())) {
            this.player = p;
            this.worldName = loc1.getWorld().getName();
            this.X1 = Math.min(loc1.getBlockX(), loc2.getBlockX());
            this.Z1 = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
            this.Y1 = Math.min(loc1.getBlockY(), loc2.getBlockY());

            this.X2 = Math.max(loc1.getBlockX(), loc2.getBlockX());
            this.Z2 = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
            this.Y2 = Math.max(loc1.getBlockY(), loc2.getBlockY());
        } else {
            System.out.println("[PrisemutsWorldEdit] Points must be in one world!");
        }
    }

    public int getUpper(String var) {
        if (var.equals("X")) {
            return this.X2;
        } else if (var.equals("Y")) {
            return this.Y2;
        } else if (var.equals("Z")) {
            return this.Z2;
        } else {
            return 0;
        }
    }

    public int getLower(String var) {
        if (var.equals("X")) {
            return this.X1;
        } else if (var.equals("Y")) {
            return this.Y1;
        } else if (var.equals("Z")) {
            return this.Z1;
        } else {
            return 0;
        }
    }

    public World getWorld() {
        World w = Bukkit.getWorld(this.worldName);
        return w;
    }

    public Location getCenter() {
        int x1 = this.getUpper("X") + 1;
        int y1 = this.getUpper("Y") + 1;
        int z1 = this.getUpper("Z") + 1;
        return new Location(this.getWorld(), this.getLower("X") + (x1 - this.getLower("X")) / 2.0,
                this.getLower("Y") + (y1 - this.getLower("Y")) / 2.0,
                this.getLower("Z") + (z1 - this.getLower("Z")) / 2.0);
    }

    public ArrayList<Block> getBlocks() {
        Iterator<Block> blockI = this.iterator();
        ArrayList<Block> copy = new ArrayList<Block>();
        while (blockI.hasNext())
            copy.add(blockI.next());
        return copy;
    }

    /*
     * Filling
     */
    public void fillCube(Material mat) {
        for(int i = 0; i < getBlocks().size(); i++) {
            getBlocks().get(i).setType(mat);
        }
    }

    public Iterator<Block> iterator() {
        return new BlackIterator(this.getWorld(), this.X1, this.Y1, this.Z1, this.X2, this.Y2, this.Z2);
    }

    public Map<String, Object> serialize() {
        return null;
    }

    public class BlackIterator implements Iterator<Block> {
        private World w;
        private int baseX, baseY, baseZ;
        private int x, y, z;
        private int sizeX, sizeY, sizeZ;

        public BlackIterator(World w, int x1, int y1, int z1, int x2, int y2, int z2) {
            this.w = w;
            this.baseX = x1;
            this.baseY = y1;
            this.baseZ = z1;
            this.sizeX = Math.abs(x2 - x1) + 1;
            this.sizeY = Math.abs(y2 - y1) + 1;
            this.sizeZ = Math.abs(z2 - z1) + 1;
            this.x = this.y = this.z = 0;
        }

        public boolean hasNext() {
            return this.x < this.sizeX && this.y < this.sizeY && this.z < this.sizeZ;
        }

        public Block next() {
            Block b = this.w.getBlockAt(this.baseX + this.x, this.baseY + this.y, this.baseZ + this.z);
            if (++x >= this.sizeX) {
                this.x = 0;
                if (++this.y >= this.sizeY) {
                    this.y = 0;
                    ++this.z;
                }
            }
            return b;
        }

        public void remove() {
        }
    }

}
