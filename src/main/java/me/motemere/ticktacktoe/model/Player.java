package me.motemere.ticktacktoe.model;

import me.motemere.ticktacktoe.utils.Utils;

public class Player {

  public String sign;

  public String getSign() {
    return sign;
  }

  public void init() {
    this.sign = Utils.scanSign();
  }

  public void switchSign() {
    if (sign.equals("x")) {
      sign = "o";
    } else if (sign.equals("o")) {
      sign = "x";
    }
  }

  public void announce() {
    Utils.announce(sign);
  }
}
