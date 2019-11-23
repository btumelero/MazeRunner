import mazerunner.MazeRunner;

public class Maze {

  static String[][] maze = {
    {"#", "@", "#", "#", "#", "#", "#", "#", "#", "#"},
    {"#", " ", " ", "#", " ", " ", " ", " ", " ", "#"},
    {"#", "#", " ", "#", " ", "#", "#", "#", " ", "#"},
    {"#", " ", " ", "#", " ", "#", " ", " ", " ", "#"},
    {"#", " ", "#", "#", " ", "#", " ", "#", "#", "#"},
    {"#", " ", " ", " ", " ", "#", " ", " ", " ", "#"},
    {"#", "#", "#", "#", "#", "#", "#", "#", " ", "#"}
  };

  public static String Solve(String[][] maze){
    MazeRunner mazeRunner = new MazeRunner(maze);
    mazeRunner.explore();
    mazeRunner.think();
    String explanation = mazeRunner.explain();
    System.out.println(explanation);
    return explanation;
  }

  public static void main(String[] args) {
    Maze.Solve(Maze.maze);
  }

}