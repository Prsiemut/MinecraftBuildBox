package de.prisemut.mbb.structure;

import org.bukkit.Location;

import java.util.ArrayList;

public class KI_Translater {

    public static ArrayList<String> listLocationString(String kidata) {
        ArrayList<String> list = new ArrayList<String>();
        String[] location = kidata.split("|");
        for(String str : location) {
            String[] data = str.split(";");
            //data[0] = id  | data[1] = location
            list.add(data[1]);
        }
        return list;
    }
}
