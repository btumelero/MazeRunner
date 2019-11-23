package maze.mazerunner;

class StringMaze {

  final String[][] maze;

  /**
   * Lazily check if position exists and it's a valid path (XGH)
   * @param position The position to be checked
   * @return True if position exists and it's a valid path
   */
  boolean existsAndIsPath(Position position) {
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
  boolean isPath (Position position) {
    return maze[position.l][position.c].equals(" ");
  }

  String get(int l, int c) {
    return maze[l][c];
  }

  int lines() {
    return maze.length;
  }

  int columns() {
    return maze[0].length;
  }

  StringMaze(String[][] maze) {
    this.maze = maze;
  }
}