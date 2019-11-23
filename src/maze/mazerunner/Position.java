package maze.mazerunner;

import java.util.ArrayList;

class Position {

  Position origin;
  final ArrayList<Position> possiblePaths;
  int l, c;

  Position left() {
    return new Position(l, c - 1);
  }

  Position right() {
    return new Position(l, c + 1);
  }

  Position up() {
    return new Position(l - 1, c);
  }

  Position down() {
    return new Position(l + 1, c);
  }

  String movementDirection(Position position) {
    int movement = position.l - l;
    if (movement < 0) {
      return "0";
    }
    if (movement > 0) {
      return "2";
    }
    movement = position.c - c;
    if (movement < 0) {
      return "3";
    }
    if (movement > 0) {
      return "1";
    }
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Position) {
      Position pos = (Position) obj;
      return this.l == pos.l && this.c == pos.c;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Maze[" + l + "][" + c + "]";
  }

  Position() {
    this.possiblePaths = new ArrayList<>();
  }

  Position(int l, int c) {
    this();
    this.l = l;
    this.c = c;
  }

}