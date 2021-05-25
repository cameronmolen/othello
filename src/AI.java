public class AI {

  private static String aiPiece = Fonts.setColor(" o", "red");

  public static void makeMove() {
    Gameboard.findPossibleSpots(aiPiece);
    int longest = Integer.MIN_VALUE;
    int counter;
    int r = -1;
    int c = -1;
    double n = 1; // Number of longests
    boolean connection;
    for(int i = 1; i < Gameboard.board.length; i++) {
      connection = false;
      for(int j = 1; j < Gameboard.board[i].length; j++) {
        if(Gameboard.checkIfMovePossible(i, j)) { // Checks if a move is possible at every coordinate
          counter = 1;

          if(Gameboard.checkHorizontalLtR(i, j, aiPiece)) { // Checks if the connection is to the right
            int col = j + 1;
            while(connection == false) {
              if(Gameboard.board[i][col].equals(aiPiece)) {
                connection = true;
              }
              else {
                counter++;
              }
              col++;
            }
          }


          if(Gameboard.checkHorizontalRtL(i, j, aiPiece)) { // Checks if the connection is to the left
            int col = j - 1;
            while(connection == false) {
              if(Gameboard.board[i][col].equals(aiPiece)) {
                connection = true;
              }
              else {
                counter++;
              }
              col--;
            }
          }


          if(Gameboard.checkVerticalTtB(i, j, aiPiece)) { // Checks if the connection is down
            int row = i + 1;
            while(connection == false) {
              if(Gameboard.board[row][j].equals(aiPiece)) {
                connection = true;
              }
              else {
                counter++;
              }
              row++;
            }
          }


          if(Gameboard.checkVerticalBtT(i, j, aiPiece)) { // Checks if the connection is up
            int row = i - 1;
            while(connection == false) {
              if(Gameboard.board[row][j].equals(aiPiece)) {
                connection = true;
              }
              else {
                counter++;
              }
              row--;
            }
          }


          if(Gameboard.checkDiagonalDownLtR(i, j, aiPiece)) { // Checks if the connection is diagonally down to the right
            int row = i + 1;
            int col = j + 1;
            while(connection == false) {
              if(Gameboard.board[row][col].equals(aiPiece)) {
                connection = true;
              }
              else {
                counter++;
              }
              row++;
              col++;
            }
          }


          if(Gameboard.checkDiagonalDownRtL(i, j, aiPiece)) { // Checks if the connection is diagonally down to the left
            int row = i + 1;
            int col = j - 1;
            while(connection == false) {
              if(Gameboard.board[row][col].equals(aiPiece)) {
                connection = true;
              }
              else {
                counter++;
              }
              row++;
              col--;
            }
          }


          if(Gameboard.checkDiagonalUpLtR(i, j, aiPiece)) { // Checks if the connection is diagonally up to the right
            int row = i - 1;
            int col = j + 1;
            while(connection == false) {
              if(Gameboard.board[row][col].equals(aiPiece)) {
                connection = true;
              }
              else {
                counter++;
              }
              row--;
              col++;
            }
          }


          if(Gameboard.checkDiagonalUpRtL(i, j, aiPiece)) { // Checks if the connection is diagonally up to the left
            int row = i - 1;
            int col = j - 1;
            while(connection == false) {
              if(Gameboard.board[row][col].equals(aiPiece)) {
                connection = true;
              }
              else {
                counter++;
              }
              row--;
              col--;
            }
          }


          if(counter > longest) {
            longest = counter;
            r = i;
            c = j;
            n = 1;
          }
          else if(counter == longest) {
            if(Math.random() < (double)(1/(n+1))) {
              r = i;
              c = j;
            }
            n++;
          }
        }
      }
    }

    Gameboard.placePiece(r, c, Fonts.setColor(" o", "fuchsia"));
    Gameboard.printBoard();
    Gameboard.removeMarker();
    System.out.println("\nTurn ended!");
    try {
      Thread.sleep(3500);
    }
    catch ( InterruptedException e ) {
      System.out.println("Uh, boss we found a problem...");
    }
    PlayGame.playTurn1();
  }

    /*
        1. Check if move is possible
        2. Scan every possible direction it could be in
        3. Get the length of each location that can be played on
        4. Compare the lengths of each location and play on the longest length
    */

  public static String getTaunt() {
    String[] taunts = {"Wow!", "Thanks!", "Well played!", "Oops, that was a mistake.", "LOL", "Good game!", "That sucked.", "You\'re trash.", "What even was that?", "Bro you suck.", "Um, why did you do <i>that</i>?"};
    int select = (int) (Math.random() * taunts.length);
    return taunts[select];
  }

}