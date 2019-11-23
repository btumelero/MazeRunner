package mazerunner;

import java.util.HashSet;

class PathSet {

  private final HashSet<Position> paths;

  /**
   * Adds the path if it's a new one
   * @param path The path to be added
   * @return True if added the new path
   */
  boolean addIfAbsent(Position path) {
    if (contains(path) == false) {
      paths.add(path);
      return true;
    }
    return false;
  }

  /**
   * Returns true if contains the path to be checked
   * @param otherPath The path to check
   * @return True if contains the path
   */
  boolean contains(Position otherPath) {
    for (Position path : paths) {
      if (path.equals(otherPath)) {
        return true;
      }
    }
    return false;
  }

  boolean containsWithL(int l) {
    for (Position path : paths) {
      if (path.l == l) {
        return true;
      }
    }
    return false;
  }

  PathSet () {
    this.paths = new HashSet<>();
  }
}