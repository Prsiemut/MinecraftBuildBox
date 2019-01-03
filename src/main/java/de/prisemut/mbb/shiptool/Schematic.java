package de.prisemut.mbb.shiptool;

public class Schematic {

    private short[] blocks;
    private byte[] data;
    private String name;
    private short width;
    private short length;
    private short height;

    public Schematic(String name, short[] blocks, byte[] data, short width, short length, short height) {
        this.name = name;
        this.blocks = blocks;
        this.data = data;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    /**
     * @return the blocks
     */
    public short[] getBlocks()
    {
        return blocks;
    }

    /**
     * @return the data
     */
    public byte[] getData()
    {
        return data;
    }

    /**
     * @return the width
     */
    public short getWidth()
    {
        return width;
    }

    /**
     * @return the lenght
     */
    public short getLenght()
    {
        return length;
    }

    /**
     * @return the height
     */
    public short getHeight()
    {
        return height;
    }
}
