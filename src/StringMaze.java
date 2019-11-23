public class StringMaze {

  String[][] maze;

  public boolean exists(int[] position) {
    try {
      return maze[position[0]][position[1]] != null;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * @return the maze
   */
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