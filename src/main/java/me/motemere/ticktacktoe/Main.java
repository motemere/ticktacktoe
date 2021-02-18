package me.motemere.ticktacktoe;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import me.motemere.ticktacktoe.model.Field;
import me.motemere.ticktacktoe.model.Game;
import me.motemere.ticktacktoe.model.Player;
import me.motemere.ticktacktoe.model.Point;

/**
 * XO CLI game.
 *
 * @author motemere at Wed Jan 29
 */
public class Main {

  /**
   * Endpoint.
   *
   * @param args CLI args.
   */
  public static void main(String[] args) {
    Game game = new Game();

    Player player = new Player();
    player.init();
    game.setPlayer(player);

    Field field = new Field.Builder()
        .base(new Point[3][3])
        .build();

    game.setField(field);

    IntConsumer action = i -> {
      game.action();

      if (game.hasWinner()) {
        game.publishLine(
            String.format(
                "Game over! <%s> are winner.", game.getPlayer().getSign()));
        System.exit(-1);
      }
    };

    IntStream.range(0, 9).forEach(action);

    game.publishLine("No winner. Good luck at the next time!");
  }
}
