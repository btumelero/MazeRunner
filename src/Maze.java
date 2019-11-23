public class Maze {

  String[][] maze = {
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
    mazeRunner.runEverywhere();
    return null;
  }



}