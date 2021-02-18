package me.motemere.ticktacktoe.model;

import me.motemere.ticktacktoe.utils.IWriter;
import me.motemere.ticktacktoe.utils.Utils;

public class Game {

  private Player player;
  private Field field;
  private final IWriter writer;

  public Game() {
    this.writer = new IWriter() {
    };
  }

  public void publishLine(String string) {
    writer.writeLine(string);
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }

  public void action() {
    player.announce();

    Point newPoint;

    boolean validPoint = false;

    do {
      int x = Utils.scanX();
      int y = Utils.scanY();

      newPoint = new Point(x, y, player.getSign().charAt(0));

      if (field.checkPoint(newPoint)) {
        validPoint = true;
      } else {
        Utils.printIncorrectPoint(newPoint);
      }
    } while (!validPoint);

    field.storePoint(newPoint);
    field.print();
  }

  public boolean hasWinner() {
    final boolean b = field.checkLines() || field.checkColumns() || field.checkDiagonales();

    if (!b) {
      player.switchSign();
    }
    
    return b;
  }

  public void setField(Field field) {
    this.field = field;
  }
}
