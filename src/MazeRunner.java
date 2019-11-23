public class MazeRunner {

  Position origin;
  StringMaze maze;

  public Position findOrigin() {
    for (int l = 0; l < maze.width(); l++) {
      for (int c = 0; c < maze.height(); c++) {
        if (maze.get(l, c).equals("@")) {
          return new Position().setL(l).setC(c);
        }
      }
    }
    return null;
  }

  public void run(Position pos) {
    int[] position = pos.up();
    if (maze.exists(position)) {
      pos.next.add(new Position(position));
    }
    //
    position = pos.right();
    if (maze.exists(position)) {

    }
    position = pos.down();
    if (maze.exists(position)) {

    }
    position = pos.left();
    if (maze.exists(position)) {

    }
  }

  

  public MazeRunner(String[][] maze) {
    this.maze = new StringMaze(maze);
    this.origin = findOrigin();
  }
}