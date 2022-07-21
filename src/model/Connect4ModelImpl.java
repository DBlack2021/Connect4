package model;

/**
 * An implementation of a Connect4Model. Has a board with a width and height (7 x 6 by default)
 * that pieces can be dropped in.
 */
public class Connect4ModelImpl implements Connect4Model {

  private final SlotState[][] board;
  private SlotState turn = SlotState.BLACK;
  private final int WIDTH, HEIGHT;

  /**
   * Creates a new Connect4ModelImpl with a default width of 7 and height of 6.
   */
  public Connect4ModelImpl() {
    this(7, 6);
  }

  /**
   * Creates a new Connect4ModelImpl with a provided width and height.
   *
   * @param width the width of the board
   * @param height the height of the board
   * @throws IllegalArgumentException if either width or height are less than or equal to zero
   */
  // INVARIANT: width >= 0
  // INVARIANT: height >= 0
  public Connect4ModelImpl(int width, int height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive integers!");
    }

    this.WIDTH = width;
    this.HEIGHT = height;
    this.board = this.initializeBoard(this.WIDTH, this.HEIGHT);
  }

  private SlotState[][] initializeBoard(int width, int height) {
    SlotState[][] board = new SlotState[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        board[i][j] = SlotState.EMPTY;
      }
    }

    return board;
  }

  private int findLastIndexOfEmpty(int col) {
    // go through each row[col] except the last one
    for (int i = 0; i < this.HEIGHT - 1; i++) {
      // if we're at an empty slot and the next slot is not empty
      if (this.board[i][col].equals(SlotState.EMPTY) && !this.board[i + 1][col].equals(SlotState.EMPTY)) {
        return i;
      }
    }

    // we made it to the bottom
    return this.HEIGHT - 1;
  }

  @Override
  public void move(int col) {
    if (col < 0 || col > this.WIDTH - 1) {
      throw new IllegalArgumentException("Column out of bounds.");
    }

    this.board[this.findLastIndexOfEmpty(col)][col] = this.turn;
    this.toggleTurn();
  }

  private boolean hasHorizontalWin() {
    return false;
  }

  private boolean hasVerticalWin() {
    return false;
  }

  private boolean hasDiagonalWin() {
    return false;
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public void toggleTurn() {
    if (this.turn.equals(SlotState.BLACK)) {
      this.turn = SlotState.RED;
    } else if (this.turn.equals(SlotState.RED)) {
      this.turn = SlotState.BLACK;
    }
  }

  @Override
  public SlotState getSlotAt(int row, int col) {
    return this.board[row][col];
  }

  @Override
  public int getWidth() {
    return this.WIDTH;
  }

  @Override
  public int getHeight() {
    return this.HEIGHT;
  }
}
