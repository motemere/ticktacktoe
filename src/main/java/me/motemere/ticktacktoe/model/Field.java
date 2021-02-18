package me.motemere.ticktacktoe.model;

import me.motemere.ticktacktoe.utils.Utils;

public class Field {

  private final Point[][] base;

  public Field(Point[][] base) {
    this.base = base;
  }

  public boolean checkPoint(Point newPoint) {
    return base[newPoint.getX()][newPoint.getY()] == null;
  }

  public void storePoint(Point newPoint) {
    base[newPoint.getX()][newPoint.getY()] = newPoint;
  }

  public void print() {
    Utils.printField(base);
  }

  public boolean checkLines() {
    for (int i : Utils.range(0, 3)) {
      if (base[i][0] != null && base[i][1] != null && base[i][2] != null) {
        return base[i][0].getSign() == base[i][1].getSign()
            && base[i][1].getSign() == base[i][2].getSign();
      }
    }

    return false;
  }

  public boolean checkColumns() {
    for (int i : Utils.range(0, 3)) {
      if (base[0][i] != null && base[1][i] != null && base[2][i] != null) {
        return base[0][i].getSign() == base[1][i].getSign()
            && base[1][i].getSign() == base[2][i].getSign();
      }
    }

    return false;
  }

  public boolean checkDiagonales() {
    if (base[0][0] != null && base[1][1] != null && base[2][2] != null) {
      return base[0][0].getSign() == base[1][1].getSign()
          && base[1][1].getSign() == base[2][2].getSign();
    }

    if (base[0][2] != null && base[1][1] != null && base[2][0] != null) {
      return base[0][2].getSign() == base[1][1].getSign()
          && base[1][1].getSign() == base[2][0].getSign();
    }

    return false;
  }

  public static class Builder {

    private Point[][] base = null;

    public Builder base(Point[][] base) {
      this.base = base;
      return this;
    }

    public Field build() {
      if (this.base == null) {
        throw new NullPointerException();
      }

      return new Field(this.base);
    }
  }
}
