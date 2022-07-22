package controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Connect4Model;
import view.Connect4View;

public class Connect4ControllerImpl implements Connect4Controller {
  private final Connect4Model model;
  private final Connect4View view;
  private final Readable in;

  public Connect4ControllerImpl(Connect4Model model, Connect4View view) {
    this(model, view, new InputStreamReader(System.in));
  }

  public Connect4ControllerImpl(Connect4Model model, Connect4View view, Readable in) {
    this.model = model;
    this.view = view;
    this.in = in;
  }

  @Override
  public void playGame() throws IllegalStateException {
    try {
      Scanner scan = new Scanner(this.in);
      view.renderMessage("Welcome to Connect4!\n");

      while(!model.isGameOver()) {
        view.renderBoard();
        view.renderMessage("Enter the column you'd like to drop your piece in: ");
        int column = scan.nextInt();
        model.move(column);
      }

      view.renderBoard();
      System.out.println("Game over!");
    } catch (IOException | NoSuchElementException e) {
      throw new IllegalStateException("Could not read or write to in or out");
    }
  }
}
