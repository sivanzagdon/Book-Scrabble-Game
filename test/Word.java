package test;

import java.util.Arrays;

//מילה
public class Word {
    // משתנים
    private Tile[] tiles;
    // שורה
    private int row;
    // עמודה
    private int col;
    // האם אנכית או לא
    private boolean vertical;

    // קונסטרקטור
    public Word(Tile[] tiles, int row, int col, boolean vertical) {
        this.tiles = new Tile[tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            this.tiles[i] = tiles[i];
        }
        this.row = row;
        this.col = col;
        this.vertical = vertical;
    }

    public boolean isVertical() {
        return vertical;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (!Arrays.equals(tiles, other.tiles))
            return false;
        if (row != other.row)
            return false;
        if (col != other.col)
            return false;
        if (vertical != other.vertical)
            return false;
        return true;
    }

    public Tile[] getTiles() {
        return tiles;
    }

}