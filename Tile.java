package test;

import java.util.concurrent.ThreadLocalRandom;

public class Tile {

  public final char letter;
  public final int score;

  private Tile(char l, int s) {
    this.letter = l;
    this.score = s;
  }

  public char getLetter() {
    return letter;
  }

  public int getScore() {
    return this.score;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + letter;
    result = prime * result + score;
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
    Tile other = (Tile) obj;
    if (letter != other.letter)
      return false;
    if (score != other.score)
      return false;
    return true;
  }

  public static class Bag {
    private static Bag singletonBag = null;

    int[] letterQuantities = { 9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1 };
    Tile[] Tiles = new Tile[] { new Tile('A', 1), new Tile('B', 3),
        new Tile('C', 3), new Tile('D', 2),
        new Tile('E', 1), new Tile('F', 4),
        new Tile('G', 2), new Tile('H', 4),
        new Tile('I', 1), new Tile('J', 8),
        new Tile('K', 5), new Tile('L', 1),
        new Tile('M', 3), new Tile('N', 1),
        new Tile('O', 1), new Tile('P', 3),
        new Tile('Q', 10), new Tile('R', 1),
        new Tile('S', 1), new Tile('T', 1),
        new Tile('U', 1), new Tile('V', 4),
        new Tile('W', 4), new Tile('X', 8),
        new Tile('Y', 4), new Tile('Z', 10) };
    int[] copy = letterQuantities.clone();

    public int size() {
      int sum = 0;
      for (int i = 0; i < 26; i++) {
        sum = +letterQuantities[i];
      }
      return sum;
    }

    public static Bag getBag() {
      if (singletonBag == null) {
        singletonBag = new Bag();
      }
      return singletonBag;
    }

    public static int getAlphabetPosition(char letter) {
      if (letter >= 'A' && letter <= 'Z') {
        return letter - 'A' + 1;
      } else {
        return -1; // אות לא תקינה או שהיא לא אות גדולה
      }
    }

    public Tile getRand() {
      // Lottery number
      int randomNumber = ThreadLocalRandom.current().nextInt(26);

      char let = Tiles[randomNumber].getLetter();
      int location = randomNumber;

      // It is not possible to get any tile if its quantity has dropped to 0:
      if (letterQuantities[location] == 0)
        return null;

      // If the bag is empty
      if (size() == 0)
        return null;

      this.letterQuantities[location] -= 1;

      return this.Tiles[randomNumber];
    }

    public Tile getTile(char l) {

      int location = getAlphabetPosition(l) - 1;

      if (location == -2)
        return null;

      // It is not possible to get any tile if its quantity has dropped to 0:
      if (letterQuantities[location] == 0)
        return null;

      // If the bag is empty
      if (this.Tiles == null)
        return null;

      this.letterQuantities[location] = -1;

      for (int i = 0; i < 26; i++) {
        if (this.Tiles[i].getLetter() == l)
          return Tiles[i];
      }
      return null;
    }

    public void put(Tile t) {
      char c = t.getLetter();

      int location = getAlphabetPosition(c) - 1;

      if (this.letterQuantities[location] < this.copy[location])
        this.letterQuantities[location] += 1;

    }

    public int[] getQuantities() {
      return this.letterQuantities.clone();

    }

  }
}
