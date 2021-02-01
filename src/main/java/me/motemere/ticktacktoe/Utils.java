package me.motemere.ticktacktoe;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Utils {

  private static IWriter writer;

  static {
    writer = new IWriter() {
    };
  }

  /**
   * Returns a range of integers.
   *
   * @param fromInclusive initial value (inclusive).
   * @param toExclusive   final value (not included).
   * @return Iterable, containing numbers from fromInclusive to toExclusive.
   */
  public static Iterable<Integer> range(int fromInclusive, int toExclusive) {
    return () -> new Iterator<Integer>() {
      int cursor = fromInclusive;

      public boolean hasNext() {
        return cursor < toExclusive;
      }

      public Integer next() {
        return cursor++;
      }
    };
  }

  public static String scanSign() {
    Scanner scanRole = new Scanner(System.in);

    boolean validData = false;
    String playerInput = null;

    do {
      writer.write("Enter your sign, please (one symbol, 'x' or 'o'): ");

      try {
        playerInput = scanRole.next();
        if (playerInput.charAt(0) == 'x' || playerInput.charAt(0) == 'o') {
          validData = true;
        } else {
          writer.write("Invalid role. ");
        }
      } catch (InputMismatchException e) {
        //executes when this exception occurs
      }
    } while (!validData);

    writer.write(String.format("Your sign now is <%s>\n", playerInput.charAt(0)));

    return playerInput.substring(0, 1);
  }

  public static int scanX() {
    Scanner scanHorizontalPosition = new Scanner(System.in);

    int x = -1;

    do {
      writer.write("Enter horizontal position, please (one number, from 0 to 2): ");

      try {
        x = scanHorizontalPosition.nextInt();
        if (0 <= x && x <= 2) {
          writer.write(String.format("Your horizontal position is <%d>\n", x));
        } else {
          writer.write("Invalid number. ");
          x = -1;
        }
      } catch (InputMismatchException e) {
        //executes when this exception occurs
      }
    } while (x < 0);

    return x;
  }

  public static int scanY() {
    Scanner scanVerticalPosition = new Scanner(System.in);

    int y = -1;

    do {
      writer.write("Enter vertical position, please (one number, from 0 to 2): ");

      try {
        y = scanVerticalPosition.nextInt();
        if (0 <= y && y <= 2) {
          writer.write(String.format("Your vertical position is <%d>\n", y));
        } else {
          writer.write("Invalid number. ");
          y = -1;
        }
      } catch (InputMismatchException e) {
        //executes when this exception occurs
      }
    } while (y < 0);

    return y;
  }

  public static void announce(String sign) {
    writer.writeLine(String.format("Next pass for player <%s> ...", sign));
  }

  public static void printField(Point[][] base) {
    writer.write(" ");
    writer.write(base[0][0] != null ? base[0][0].getSign() : ' ');
    writer.write(" | ");
    writer.write(base[0][1] != null ? base[0][1].getSign() : ' ');
    writer.write(" | ");
    writer.write(base[0][2] != null ? base[0][2].getSign() : ' ');
    writer.write(" ");

    writer.writeLine("\n-----------");

    writer.write(" ");
    writer.write(base[1][0] != null ? base[1][0].getSign() : ' ');
    writer.write(" | ");
    writer.write(base[1][1] != null ? base[1][1].getSign() : ' ');
    writer.write(" | ");
    writer.write(base[1][2] != null ? base[1][2].getSign() : ' ');
    writer.write(" ");

    writer.writeLine("\n-----------");

    writer.write(" ");
    writer.write(base[2][0] != null ? base[2][0].getSign() : ' ');
    writer.write(" | ");
    writer.write(base[2][1] != null ? base[2][1].getSign() : ' ');
    writer.write(" | ");
    writer.write(base[2][2] != null ? base[2][2].getSign() : ' ');
    writer.writeLine("");
  }

  public static void printIncorrectPoint(Point newPoint) {
    writer.writeLine(
        String.format("New point <%s> is incorrect. Please try again.", newPoint.toString()));
  }
}
