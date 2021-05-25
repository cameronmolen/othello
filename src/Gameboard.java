public class Gameboard {

  // The gameboard
  public static String[][] board =
          {{" ", " a", " b", " c", " d", " e", " f", " g", " h"},
                  {"1", " -", " -", " -", " -", " -", " -", " -", " -"},
                  {"2", " -", " -", " -", " -", " -", " -", " -", " -"},
                  {"3", " -", " -", " -", " -", " -", " -", " -", " -"},
                  {"4", " -", " -", " -", Fonts.setColor(" x", "blue"), Fonts.setColor(" o", "red"), " -", " -", " -"},
                  {"5", " -", " -", " -", Fonts.setColor(" o", "red"), Fonts.setColor(" x", "blue"), " -", " -", " -"},
                  {"6", " -", " -", " -", " -", " -", " -", " -", " -"},
                  {"7", " -", " -", " -", " -", " -", " -", " -", " -"},
                  {"8", " -", " -", " -", " -", " -", " -", " -", " -"}};

  /** Prints out the gameboard. */
  public static void printBoard() {
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println(" ");
    }
  }

    /*
    1. Print out possible locations
        a) Scan through **EMPTY** rows and columns
            -Check to see if there are any filled spaces around it first, if not, then go to next space
        b) Check at each location if there is a possible connection between two pieces
            -Find on which sides there are pieces touching the location
            -Ex. Scan left to right, if connection == true, then print that possibility
    2. Place piece and change pieces connecting
    */

  /** Checks horizontal from left to right and places a # if there is a connection. */
  public static boolean checkHorizontalLtR(int row, int col, String piece) {
    boolean connection = false;
    if((board[row][col].equals(" -") || board[row][col].equals(" #")) && col != board[row].length - 1 && !board[row][col + 1].equals(piece) && !board[row][col + 1].equals(" -")) {
      int c = col + 1;
      while(c < board[row].length && connection == false && !board[row][c].equals(" -")) {
        if(board[row][c].equals(piece)) {
          connection = true;
          board[row][col] = " #";
        }
        c++;
      }
    }
    return connection;
  }

  /** Checks horizontal from rihgt to left and places a # if there is a connection. */
  public static boolean checkHorizontalRtL(int row, int col, String piece) {
    boolean connection = false;
    if((board[row][col].equals(" -") || board[row][col].equals(" #")) && col > 1 && !board[row][col - 1].equals(piece) && !board[row][col - 1].equals(" -") && !board[row][col - 1].equals(" #")) {
      int c = col - 1;
      while(c > 0 && connection == false && !board[row][c].equals(" -")) {
        if(board[row][c].equals(piece)) {
          connection = true;
          board[row][col] = " #";
        }
        c--;
      }
    }
    return connection;
  }

  /** Checks vertical from top to bottom and places a # if there is a connection. */
  public static boolean checkVerticalTtB(int row, int col, String piece) {
    boolean connection = false;
    if((board[row][col].equals(" -") || board[row][col].equals(" #")) && row != board.length - 1 && !board[row + 1][col].equals(piece) && !board[row + 1][col].equals(" -")) {
      int r = row + 1;
      while(r < board.length && connection == false && !board[r][col].equals(" -")) {
        if(board[r][col].equals(piece)) {
          connection = true;
          board[row][col] = " #";
        }
        r++;
      }
    }
    return connection;
  }

  /** Checks vertical from bottom to top and places a # if there is a connection. */
  public static boolean checkVerticalBtT(int row, int col, String piece) {
    boolean connection = false;
    if((board[row][col].equals(" -") || board[row][col].equals(" #")) && row > 1 && !board[row - 1][col].equals(piece) && !board[row - 1][col].equals(" -") && !board[row - 1][col].equals(" #")) {
      int r = row - 1;
      while(r > 0 && connection == false && !board[r][col].equals(" -")) {
        if(board[r][col].equals(piece)) {
          connection = true;
          board[row][col] = " #";
        }
        r--;
      }
    }
    return connection;
  }

  /** Checks diagonal down from the left to the right and places a # if there is a connection. */
  public static boolean checkDiagonalDownLtR(int row, int col, String piece) {
    boolean connection = false;
    if((board[row][col].equals(" -") || board[row][col].equals(" #")) && row < board.length - 1 && col < board[0].length - 1 && !board[row + 1][col + 1].equals(piece) && !board[row + 1][col + 1].equals(" -") && !board[row + 1][col + 1].equals(" #")) {
      int c = col + 1;
      int r = row + 1;
      while(c < board[row].length && r < board.length && connection == false && !board[r][c].equals(" -")) {
        if(board[r][c].equals(piece)) {
          connection = true;
          board[row][col] = " #";
        }
        r++;
        c++;
      }
    }
    return connection;
  }

  /** Checks diagonal down from the right to the left and places a # if there is a connection. */
  public static boolean checkDiagonalDownRtL(int row, int col, String piece) {
    boolean connection = false;
    if((board[row][col].equals(" -") || board[row][col].equals(" #")) && row < board.length - 1 && col > 1 && !board[row + 1][col - 1].equals(piece) && !board[row + 1][col - 1].equals(" -") && !board[row + 1][col - 1].equals(" #")) {
      int c = col - 1;
      int r = row + 1;
      while(c > 0 && r < board.length && connection == false && !board[r][c].equals(" -")) {
        if(board[r][c].equals(piece)) {
          connection = true;
          board[row][col] = " #";
        }
        r++;
        c--;
      }
    }
    return connection;
  }

  /** Checks diagonal up from the left to the right and places a # if there is a connection. */
  public static boolean checkDiagonalUpLtR(int row, int col, String piece) {
    boolean connection = false;
    if((board[row][col].equals(" -") || board[row][col].equals(" #")) && row > 0 && col < board[0].length - 1 && !board[row - 1][col + 1].equals(piece) && !board[row - 1][col +1].equals(" -") && !board[row - 1][col + 1].equals(" #")) {
      int c = col + 1;
      int r = row - 1;
      while(c < board[row].length && r > 0 && connection == false && !board[r][c].equals(" -")) {
        if(board[r][c].equals(piece)) {
          connection = true;
          board[row][col] = " #";
        }
        r--;
        c++;
      }
    }
    return connection;
  }

  /** Checks diagonal up from the right to the left and places a # if there is a connection. */
  public static boolean checkDiagonalUpRtL(int row, int col, String piece) {
    boolean connection = false;
    if((board[row][col].equals(" -") || board[row][col].equals(" #")) && row > 1 && col > 1 && !board[row - 1][col - 1].equals(piece) && !board[row - 1][col - 1].equals(" -") && !board[row - 1][col - 1].equals(" #")) {
      int c = col - 1;
      int r = row - 1;
      while(c > 0 && r > 0 && connection == false && !board[r][c].equals(" -")) {
        if(board[r][c].equals(piece)) {
          connection = true;
          board[row][col] = " #";
        }
        r--;
        c--;
      }
    }
    return connection;
  }

  /** Marks each location where a piece can be played with a "#". */
  public static void findPossibleSpots(String piece) {
    for(int i = 1; i < board.length; i++) {
      for(int j = 1; j < board[i].length; j++) {
        checkHorizontalLtR(i, j, piece);
        checkHorizontalRtL(i, j, piece);
        checkVerticalTtB(i, j, piece);
        checkVerticalBtT(i, j, piece);
        checkDiagonalDownLtR(i, j, piece);
        checkDiagonalDownRtL(i, j, piece);
        checkDiagonalUpLtR(i, j, piece);
        checkDiagonalUpRtL(i, j, piece);
      }
    }
  }

  /** Checks the coordinates indicated to see if a piece can be placed there. */
  public static boolean checkIfMovePossible(int row, int col) {
    if(board[row][col].equals(" #")) {
      return true;
    }
    else {
      return false;
    }
  }

  /** Places a piece in the location indicated and flips connecting pieces. */
  public static void placePiece(int row, int col, String piece) {
    String p1 = piece;
    if(piece.equals(Fonts.setColor(" o", "fuchsia"))) {
      piece = Fonts.setColor(" o", "red");
    }
    boolean connection = false;


    if(checkHorizontalLtR(row, col, piece)) { // Checks if the other player's piece is to the right
      for(int c = col + 1; connection == false; c++) {
        if(board[row][c].equals(piece)) {
          connection = true;
        }
        else {
          board[row][c] = piece;
        }
      }
      connection = false;
    }


    if(checkHorizontalRtL(row, col, piece)) { // Checks if the other player's piece is to the left
      for(int c = col - 1; connection == false; c--) {
        if(board[row][c].equals(piece)) {
          connection = true;
        }
        else {
          board[row][c] = piece;
        }
      }
      connection = false;
    }


    if(checkVerticalTtB(row, col, piece)) { // Checks if the other player's piece is down
      for(int r = row + 1; connection == false; r++) {
        if(board[r][col].equals(piece)) {
          connection = true;
        }
        else {
          board[r][col] = piece;
        }
      }
      connection = false;
    }


    if(checkVerticalBtT(row, col, piece)) { // Checks if the other player's piece is up
      for(int r = row - 1; connection == false; r--) {
        if(board[r][col].equals(piece)) {
          connection = true;
        }
        else {
          board[r][col] = piece;
        }
      }
      connection = false;
    }


    if(checkDiagonalDownLtR(row, col, piece)) { // Checks if the other player's piece is diagonally down to the right
      int c = col + 1;
      int r = row + 1;
      while(connection == false) {
        if(board[r][c].equals(piece)) {
          connection = true;
        }
        else {
          board[r][c] = piece;
        }
        c++;
        r++;
      }
      connection = false;
    }


    if(checkDiagonalDownRtL(row, col, piece)) { // Checks if the other player's piece is diagonally down to the left
      int c = col - 1;
      int r = row + 1;
      while(connection == false) {
        if(board[r][c].equals(piece)) {
          connection = true;
        }
        else {
          board[r][c] = piece;
        }
        c--;
        r++;
      }
      connection = false;
    }


    if(checkDiagonalUpLtR(row, col, piece)) { // Checks if the other player's piece is diagonally up to the right
      int c = col + 1;
      int r = row - 1;
      while(connection == false) {
        if(board[r][c].equals(piece)) {
          connection = true;
        }
        else {
          board[r][c] = piece;
        }
        c++;
        r--;
      }
      connection = false;
    }


    if(checkDiagonalUpRtL(row, col, piece)) { // Checks if the other player's piece is diagonally up to the left
      int c = col - 1;
      int r = row - 1;
      while(connection == false) {
        if(board[r][c].equals(piece)) {
          connection = true;
        }
        else {
          board[r][c] = piece;
        }
        c--;
        r--;
      }
      connection = false;
    }
    board[row][col] = p1;
    cleanBoard();
  }

  public static void cleanBoard() {
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if(board[i][j].equals(" #")) {
          board[i][j] = " -";
        }
      }
    }
  }

  public static void removeMarker() {
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if(board[i][j].equals(Fonts.setColor(" o", "fuchsia"))) {
          board[i][j] = Fonts.setColor(" o", "red");
        }
      }
    }
  }

}