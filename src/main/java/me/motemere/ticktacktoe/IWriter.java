package me.motemere.ticktacktoe;

public interface IWriter {

  default void writeLine(String out) {
    System.out.println(out);
  }

  default void write(String out) {
    System.out.print(out);
  }

  default void write(char charToPrint) {
    System.out.print(charToPrint);
  }
}

