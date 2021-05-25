import java.util.Scanner;
public class PlayGame {

  private static String piece;
  private static int counter = -1;

  /** Plays the game with a single user player and an AI player. */
  public static void playTurn1() {
    Gameboard.findPossibleSpots(whoseTurn(counter));
    if(piece.equals(Fonts.setColor(" o", "red"))) {
      Gameboard.cleanBoard();
      System.out.println("\n-----------------------------------------------------------------\n");
      Gameboard.printBoard();
      System.out.println("\nIt is " + Fonts.setColor("Arty", "red") + "\'s turn!");
      System.out.println("\n" + Fonts.setColor("Arty: " + AI.getTaunt(), "red") + "\nThinking...");
      try {
        Thread.sleep(4000);
      }
      catch ( InterruptedException e ) {
        System.out.println("Uh, something is up boss...");
      }
      System.out.println("");
      AI.makeMove();
    }
    else if(piece.equals(Fonts.setColor(" x", "blue"))) {
      System.out.println("\n-----------------------------------------------------------------\n\n" + "It is " + Fonts.setColor("your", "blue") + " turn!\n");
      Gameboard.printBoard();
      System.out.println("");
      PlayGame.requestMove1();
    }
  }

  /** Plays the game with two user players. */
  public static void playTurn2() {
    Gameboard.findPossibleSpots(whoseTurn(counter));
    System.out.println("\n-----------------------------------------------------------------\n\n" + "It is" + piece + "\'s turn!\n");
    Gameboard.printBoard();
    System.out.println("");
    PlayGame.requestMove2();
  }

  /** Tells the game whose turn it is, if it is the first turn, a random player will be selected. */
  private static String whoseTurn(int c) {
    if(c == -1) {
      c = (int) (Math.random() * 2) + 1;
    }
    if(c % 2 == 0) {
      piece = Fonts.setColor(" x", "blue");
      c++;
    }
    else if(c % 2 == 1) {
      piece = Fonts.setColor(" o", "red");
      c++;
    }
    counter = c;
    return piece;
  }

  /** Prompts the player to insert the coordinates of the move they would like to take. */
  private static void requestMove1() {
    Scanner userIn = new Scanner(System.in);
    System.out.println("Where would you like to play? You may play on any of the # symbols.\nType in the coordinates like this: \"letter\" [Enter], \"number\" [Enter].");
    char c = userIn.next().charAt(0);
    int col = (int)c - 96;
    int r = userIn.nextInt();
    if(Gameboard.checkIfMovePossible(r, col) == false) {
      System.out.println("Oops! That isn\'t a valid move!");
      PlayGame.requestMove1();
    }
    else {
      Gameboard.placePiece(r, col, piece);
      playTurn1();
    }
  }

  /** Prompts the player to insert the coordinates of the move they would like to take. */
  private static void requestMove2() {
    Scanner userIn = new Scanner(System.in);
    System.out.println("Where would you like to play? You may play on any of the # symbols.\nType in the coordinates like this: \"letter\" [Enter], \"number\" [Enter].");
    char c = userIn.next().charAt(0);
    int col = (int)c - 96;
    int r = userIn.nextInt();
    if(Gameboard.checkIfMovePossible(r, col) == false) {
      System.out.println("Oops! That isn\'t a valid move!");
      PlayGame.requestMove2();
    }
    else {
      Gameboard.placePiece(r, col, piece);
      playTurn2();
    }
  }

}