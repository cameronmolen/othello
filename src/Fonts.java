public class Fonts {

  /** Sets the color of a string. */
  public static String setColor(String str, String color) {
    color = color.toLowerCase();
    String cMessage = "<font color=\"" + color + "\">" + str + "</font>";
    return cMessage;
  }

  /** Sets the size of a string. */
  public static String setSize(String str, int size) {
    String sMessage = "<p style=\"font-size:" + size + "%;\">" + str + "</p>";
    return sMessage;
  }

}