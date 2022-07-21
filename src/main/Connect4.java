package main;

import java.io.IOException;
import java.util.Scanner;

import model.Connect4Model;
import model.Connect4ModelImpl;
import view.Connect4TextView;
import view.Connect4View;

public class Connect4 {
  public static void main(String[] args) throws IOException {
    Connect4Model model = new Connect4ModelImpl();
    Connect4View view = new Connect4TextView(model);

    Scanner scan = new Scanner(System.in);
    view.renderMessage("Welcome to Connect4!\n");

    while(true) {
      view.renderBoard();
      view.renderMessage("Enter the column you'd like to drop your piece in: ");
      int column = scan.nextInt();
      model.move(column);
    }
  }
}
