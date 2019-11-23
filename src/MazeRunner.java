public class MazeRunner {

  final StringMaze maze;
  final PathSet paths;

  public void runEverywhere() {
    Position origin = whereAreYou();
    System.out.println("Starting Position: Maze[" + origin.l + "][" + origin.c + "]\n");
    System.out.println("Running");
    run(origin);
  }

  public Position whereAreYou() {
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
    System.out.print(".");
    fromTo(position, position.up());
    fromTo(position, position.right());
    fromTo(position, position.down());
    fromTo(position, position.left());
  }

  public void fromTo(Position position, int[] nextPosition) {
    if (maze.existsAndIsPath(nextPosition)) {
      Position newPath = new Position(nextPosition);
      if (paths.addIfAbsent(newPath)) {
        newPath.origin = position;
        position.possiblePaths.add(newPath);
        run(newPath);
      }
    }
  }

  public MazeRunner(String[][] maze) {
    this.maze = new StringMaze(maze);
    this.paths = new PathSet();
  }
}