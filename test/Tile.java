package test;

import java.util.Random;

//Tile
public class Tile {
    // משתנים
    public final char letter;
    public final int score;

    // קונסטרקטור
    private Tile(char letter, int score) {
        this.letter = letter;
        this.score = score;
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
        Tile other = (Tile) obj;
        if (letter != other.letter)
            return false;
        if (score != other.score)
            return false;
        return true;
    }

    // hash
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + letter;
        result = prime * result + score;
        return result;
    }

    // Bag
    public static class Bag {
        private static final int LETTERS_AMOUT = 98;
        // תיק סינגלטון
        private static Bag bagSingelton = null;
        private int[] lettersQuantity;
        private Tile[] letters;

        private final int[] lettersQuantityLimit;

        private int lettersInBag;

        // קונסטרקטור
        private Bag() {
            int[] initialLetterQuantity = { 9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2,
                    1 };
            int[] lettersValue = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
            lettersQuantity = new int[26];
            letters = new Tile[26];

            for (int i = 0; i < letters.length; i++) {
                letters[i] = new Tile((char) ((int) 'A' + i), lettersValue[i]);
                lettersQuantity[i] = initialLetterQuantity[i]; // lettersQuantity = initialLetterQuantity.clone(); -
                                                               // outside for instead?
            }

            lettersInBag = LETTERS_AMOUT;
            lettersQuantityLimit = initialLetterQuantity.clone();
        }

        // הגרלת רנדומלי
        public Tile getRand() {

            if (lettersInBag == 0) {
                return null;
            }

            Random rand = new Random();
            int randomLetterIndex;

            do {
                randomLetterIndex = rand.nextInt(lettersQuantity.length);
            } while (lettersQuantity[randomLetterIndex] == 0);

            lettersQuantity[randomLetterIndex] -= 1;
            lettersInBag -= 1;
            return letters[randomLetterIndex];
        }

        // getBag
        public static Bag getBag() {
            if (bagSingelton == null) {
                bagSingelton = new Bag();
            }

            return bagSingelton;
        }

        // getQuantities
        public int[] getQuantities() {
            return lettersQuantity.clone();
        }

        // put
        public void put(Tile tile) {

            int letterIndex = tile.letter - 'A';

            if (lettersQuantity[letterIndex] < lettersQuantityLimit[letterIndex]) {
                lettersQuantity[letterIndex] += 1;
                lettersInBag += 1;
            }
        }

        public Tile getTile(char c) {

            int letterIndex = c - 'A';

            if (letterIndex < 0 || letterIndex > letters.length) {
                return null;
            }

            if (lettersQuantity[letterIndex] == 0) {
                return null;
            }

            lettersQuantity[letterIndex] -= 1;
            lettersInBag -= 1;
            return letters[letterIndex];
        }

        public int size() {
            return lettersInBag;
        }

    }
}
