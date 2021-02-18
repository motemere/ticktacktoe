package me.motemere.ticktacktoe.model;

public class Point {

  private final int x;
  private final int y;
  private final char sign;

  public Point(int x, int y, char sign) {
    this.x = x;
    this.y = y;
    this.sign = sign;
  }

  public char getSign() {
    return sign;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }

    Point point = (Point) obj;

    return this.x == point.x
        && this.y == point.y
        && this.sign == point.sign;
  }

  @Override
  public String toString() {
    return String.format("%d%d%c", x, y, sign);
  }
}
