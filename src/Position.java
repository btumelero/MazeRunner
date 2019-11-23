import java.util.ArrayList;

public class Position {
  Position previous;
  ArrayList<Position> next;
  int l, c;

  /**
   * @param l the x to set
   */
  public Position setL(int l) {
    this.l = l;
    return this;
  }

  /**
   * @param y the y to set
   */
  public Position setC(int c) {
    this.c = c;
    return this;
  }

  public int[] left() {
    return new int[] { l, c - 1 };
  }

  public int[] right() {
    return new int[] { l, c + 1 };
  }

  public int[] up() {
    return new int[] { l - 1, c };
  }
  
  public int[] down() {
    return new int[] { l + 1, c };
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Position) {
      Position pos = (Position) obj;
      return this.l == pos.l && this.c == pos.c;
    }
    return false;
  }

  public Position() {
    this.next = new ArrayList<>();
  }

  public Position(int[] lc) {
    this();
    this.l = lc[0];
    this.c = lc[1];
  }
}