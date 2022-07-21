package view;

import java.io.IOException;

public interface Connect4View {
  /**
   * Return a string that represents the current state of the board.
   * @return the game state as a string
   */
  String toString();

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  void renderBoard() throws IOException;

  /**
   * Render a specific message to the provided data destination.
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  void renderMessage(String message) throws IOException;
}
