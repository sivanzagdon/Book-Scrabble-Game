package test;

import java.util.Arrays;

public class Word {
    public Tile[] word;
    int row, col;
    boolean vertical;
    int len;

    public Word(Tile[] w, int r, int c, boolean v) {
        this.word = w;
        this.row = r;
        this.col = c;
        this.vertical = v;
    }

    Tile[] getTiles() {
        return word.clone();
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    boolean getVertical() {
        return vertical;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(word);
        result = prime * result + row;
        result = prime * result + col;
        result = prime * result + (vertical ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (!Arrays.equals(word, other.word))
            return false;
        if (row != other.row)
            return false;
        if (col != other.col)
            return false;
        if (vertical != other.vertical)
            return false;
        return true;
    }

}
