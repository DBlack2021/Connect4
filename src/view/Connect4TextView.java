package view;

import java.io.IOException;

import model.Connect4ModelState;

public class Connect4TextView implements Connect4View {
  private final Connect4ModelState state;
  private final Appendable out;

  /**
   * Creates a text view with the given state and {@code System.out} as a default Appendable.
   * @param state the state of the board to visualize
   */
  public Connect4TextView(Connect4ModelState state) {
    this(state, System.out);
  }

  /**
   * Creates a text view with the given state and Appendable output.
   * @param state the state of the board to visualize
   * @param out the output to append to
   */
  public Connect4TextView(Connect4ModelState state, Appendable out) {
    this.state = state;
    this.out = out;
  }

  @Override
  public String toString() {
    String ANSI_BLACK = "\u001B[30m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_RESET = "\u001B[0m";
    String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    String redPiece = ANSI_WHITE_BACKGROUND + ANSI_RED + "◉ " + ANSI_RESET + ANSI_WHITE_BACKGROUND;
    String blackPiece = ANSI_WHITE_BACKGROUND + ANSI_BLACK + "◉ " + ANSI_RESET + ANSI_WHITE_BACKGROUND;
    String emptyPiece =
            ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_ " + ANSI_RESET + ANSI_WHITE_BACKGROUND;

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < this.state.getHeight(); i++) {
      for (int j = 0; j < this.state.getWidth(); j++) {
        switch (this.state.getSlotAt(i, j)) {
          case EMPTY:
            result.append(emptyPiece);
            break;
          case RED:
            result.append(redPiece);
            break;
          case BLACK:
            result.append(blackPiece);
            break;
        }
      }
      result.append(ANSI_RESET + "\n");
    }

    String numbers = "";
    for (int i = 0; i < this.state.getWidth(); i++) {
      numbers += i + "|";
    }

    return numbers + "\n" + result.append(ANSI_RESET);
  }

  @Override
  public void renderBoard() throws IOException {
    this.out.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.out.append(message);
  }
}
