package de.prisemut.mbb;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class BoxPattern {

    private Material material;

    public BoxPattern(Material material) {
        this.material = material;
    }

    public Material fromID(int id) {
        return Material.getMaterial(id);
    }

    public List<Material> mixMaterials(Material material1, Material material2, int size) {
        ArrayList<Material> list = new ArrayList<>();
        int c1 = size / 2;
        int c2 = size / 2;

        for(int i = 0; i < c1; i++) {
            list.add(material1);
        }

        for(int i = 0; i < c2; i++) {
            list.add(material2);
        }

        return list;
    }

    public Material getMaterial() {
        return material;
    }

}
