public class MazeRunner {

  Position origin;
  StringMaze maze;
  PathSet paths;

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

  public void run(Position position) {
    fromTo(position, position.up());
    fromTo(position, position.right());
    fromTo(position, position.down());
    fromTo(position, position.left());
  }

  public void fromTo(Position position, int[] nextPosition) {
    if (maze.exists(nextPosition)) {
      Position newPath = new Position(nextPosition);
      if (paths.addIfAbsent(newPath)) {
        newPath.previous = position;
        position.next.add(newPath);
        run(newPath);
      }
    }
  }

  public MazeRunner(String[][] maze) {
    this.maze = new StringMaze(maze);
    this.origin = findOrigin();
  }
}