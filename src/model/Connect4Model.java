package model;

/**
 * Defines operations for a connect 4 game.
 */
public interface Connect4Model extends Connect4ModelState {
  /**
   * Drops a piece in the given column
   *
   * @param col the column to drop the piece in
   */
  void move(int col);

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  boolean isGameOver();

  /**
   * Toggles the turn. If the turn is black, makes the turn red, and vice versa.
   */
  void toggleTurn();
}
