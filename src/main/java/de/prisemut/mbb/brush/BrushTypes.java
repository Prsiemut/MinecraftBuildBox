package de.prisemut.mbb.brush;

import de.prisemut.mbb.commands.BrushCommand;

public enum BrushTypes {

    CUBE_BRUSH;

    public static BrushTypes getBrushByName(String brushname) {
        if ("cube".equals(brushname)) {
            return CUBE_BRUSH;
        } else {
            return null;
        }
    }
}
