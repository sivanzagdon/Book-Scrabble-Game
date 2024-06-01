package test;

public class Board {
   private final int dL;
   private final int dW;
   private final int tL;
   private final int tW;
   private boolean isEmpty;
   String[][] bonus;
   Tile[][] gameBoard;
   private static Board singletonGameBoard = null;

   private Board() {
       String[][] bonusCopy= {
            { "tW", null, null, "dL", null, null, null, "tW", null, null, null, "dL", null, null, "tW" },
            { 0, "dW", 0, 0, 0, "tL", 0, 0, 0, "tL", 0, 0, 0, "dW", 0 },
            { 0, 0, "dW", 0, 0, 0, "dL", 0, "dL", 0, 0, 0, "dW", 0, 0 },
            { "dL", 0, 0, "dW", 0, 0, 0, "dL", 0, 0, 0, "dW", 0, 0, "dL" },
            { 0, 0, 0, 0, "dW", 0, 0, 0, 0, 0, "dW", 0, 0, 0, 0 },
            { 0, "tL", 0, 0, 0, "tL", 0, 0, 0, "tL", 0, 0, 0, "tL", 0 },
            { 0, 0, "dL", 0, 0, 0, "dL", 0, "dL", 0, 0, 0, "dL", 0, 0 },
            { "tW", 0, 0, "dL", 0, 0, 0, "dW", 0, 0, 0, "dL", 0, 0, "tW" },
            { 0, 0, "dL", 0, 0, 0, "dL", 0, "dL", 0, 0, 0, "dL", 0, 0 },
            { 0, "tL", 0, 0, 0, "tL", 0, 0, 0, "tL", 0, 0, 0, "tL", 0 },
            { 0, 0, 0, 0, "dW", 0, 0, 0, 0, 0, "dW", 0, 0, 0, 0 },
            { "dL", 0, 0, "dW", 0, 0, 0, "dL", 0, 0, 0, "dW", 0, 0, "dL" },
            { 0, 0, "dW", 0, 0, 0, "dL", 0, "dL", 0, 0, 0, "dW", 0, 0 },
            { 0, "dW", 0, 0, 0, "tL", 0, 0, 0, "tL", 0, 0, 0, "dW", 0 },
            { "tW", 0, 0, "dL", 0, 0, 0, "tW", 0, 0, 0, "dL", 0, 0, "tW" } };

   }

   public static Board getBoard() {
      if (singletonGameBoard == null) {
         singletonGameBoard = new Board();
      }
      return singletonGameBoard;
   }

   public Tile[][] getTiles() {
      return gameBoard.clone();
   }

   public boolean inBoard(Word w) {
      return (w.col >= 0 && w.col < 15 && w.row >= 0 && w.row < 15);
   }

   private boolean onStar(Word w) {
      int i = w.getRow();
      int j = w.getCol();

      for (@SuppressWarnings("unused")
      Tile t : w.getTiles()) {
         if (i == 7 && j == 7)
            return true;
         if (w.getVertical())
            i++;
         else
            j++;
      }
      return false;
   }

   private boolean crossWord(Word w) {

   }

   public boolean boardLegal(Tile[] word) {

   }
}
