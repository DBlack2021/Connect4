package main;

import java.io.IOException;
import java.util.Scanner;

import controller.Connect4Controller;
import controller.Connect4ControllerImpl;
import model.Connect4Model;
import model.Connect4ModelImpl;
import view.Connect4TextView;
import view.Connect4View;

public class Connect4 {
  public static void main(String[] args) {
    Connect4Model model = new Connect4ModelImpl();
    Connect4View view = new Connect4TextView(model);
    Connect4Controller controller = new Connect4ControllerImpl(model, view);

    controller.playGame();
  }
}
