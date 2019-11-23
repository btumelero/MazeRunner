package maze.mazerunner;

import java.util.Stack;

public class MazeRunner {

  private final StringMaze maze;
  private final PathSet paths;
  private final Stack<Position> wayOut;
  private final Position origin;
  private String path;
  
  // #region Exploring

  public void explore() {
    System.out.println("Starting Position: " + origin + "\n");
    System.out.print("Running");
    run(origin);
  }

  private void run(Position position) {
    System.out.print(".");
    fromTo(position, position.up());
    fromTo(position, position.right());
    fromTo(position, position.down());
    fromTo(position, position.left());
  }

  private void fromTo(Position position, Position newPath) {
    if (maze.existsAndIsPath(newPath)) {
      if (paths.addIfAbsent(newPath)) {
        newPath.origin = position;
        position.possiblePaths.add(newPath);
        run(newPath);
      }
    }
  }

  // #endregion

  // #region Thinking

  public void think() {
    System.out.print("\nThinking");
    findTheWayOut(origin);
  }

  private void findTheWayOut(Position position) {
    System.out.print(".");
    if (isWayOut(position)) {
      wayOutFound(position);
    } else {
      for (Position path : position.possiblePaths) {
        findTheWayOut(path);
      }
    }
  }
  
  private void wayOutFound(Position position) {
    if (position != null) {
      wayOut.push(position);
      if (position.origin != null) {
        wayOutFound(position.origin);
      }
    }
  }
  
  private boolean isWayOut(Position position) {
    return position.l == (maze.lines() - 1);
  }

  // #endregion
  
  // #region Explaining
  
  public String explain() {
    System.out.print("\nExplaining");
    rememberTheWayOut(wayOut.pop());
    return path.isEmpty() ? "\nI couldn't find a way out." : "\nThe way out is: " + path;
  }
  
  private void rememberTheWayOut(Position position) {
    System.out.print(".");
    if (wayOut.isEmpty() == false) {
      Position otherPosition = wayOut.pop();
      path += position.movementDirection(otherPosition);
      rememberTheWayOut(otherPosition);
    }
  }
  
  // #endregion

  // #region Starting

  private Position whereAreYou() {
    for (int l = 0; l < maze.lines(); l++) {
      for (int c = 0; c < maze.columns(); c++) {
        if (maze.get(l, c).equals("@")) {
          return new Position(l, c);
        }
      }
    }
    return null;
  }

  public MazeRunner(String[][] maze) {
    this.maze = new StringMaze(maze);
    this.paths = new PathSet();
    this.wayOut = new Stack<>();
    this.origin = whereAreYou();
    this.path = "";
  }

  // #endregion
}