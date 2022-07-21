package model;

/**
 * Describes the state of a Connect 4 Game.
 */
public interface Connect4ModelState {
  /**
   * Represents the state of a slot, which can either be empty, red, or black.
   */
  enum SlotState { EMPTY, RED, BLACK }

  /**
   * Gets the state of the current slot at (row, col).
   *
   * @param row the row to look at
   * @param col the column to look at
   * @return the SlotState at (row, col) (either EMPTY, RED, or BLACK. See SlotState)
   */
  SlotState getSlotAt(int row, int col);

  /**
   * Gets the width of the board.
   * @return the width of the board in pieces
   */
  int getWidth();

  /**
   * Gets the height of the board.
   * @return the height of the board in pieces
   */
  int getHeight();
}
