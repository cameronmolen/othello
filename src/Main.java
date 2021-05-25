import java.util.Scanner;
public class Main {
  public static void main(String[] args) {

    Scanner userIn = new Scanner(System.in);

    System.out.println(Fonts.setColor(Fonts.setSize("Welcome to Othello programmed by Cameron!\n" +
            "The rules are simple: make horizontal, vertical, or diagonal connections to cover the board with your pieces!\n" +
            "You may place your pieces on the \"#\"s.\n\nWould you like to play with 1 player [1] or 2 players [2]?", 120), "steelblue"));

    int players = userIn.nextInt();

    if(players == 1) {
      Gameboard.printBoard();
      PlayGame.playTurn1();
    } else if(players == 2) {
      Gameboard.printBoard();
      PlayGame.playTurn2();
    } else {
      System.out.println("\nYou don\'t want to play? Aw that\'s too bad :/");
    }

  }
}
