public class StringMaze {

  final String[][] maze;

  /**
   * Lazily check if position exists and it's a valid path (XGH)
   * @param position The position to be checked
   * @return True if position exists and it's a valid path
   */
  public boolean existsAndIsPath(int[] position) {
    try {
      return isPath(position);
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  /**
   * Check if position is a valid path
   * @param position The position to be checked
   * @return True if position is a valid path
   */
  public boolean isPath (int[] position) {
    return maze[position[0]][position[1]].equals(" ");
  }

  public String get(int l, int c) {
    return maze[l][c];
  }

  public int height() {
    return maze[0].length;
  }

  public int width() {
    return maze.length;
  }

  public StringMaze(String[][] maze) {
    this.maze = maze;
  }
}