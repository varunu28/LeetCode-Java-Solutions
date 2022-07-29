import java.util.PrimitiveIterator.OfInt;

class Vector2D {

  private Iterator<OfInt> iterators;
  private Iterator currIterator;

  public Vector2D(int[][] vec) {
    this.iterators = Arrays.stream(vec).map(v -> Arrays.stream(v).iterator()).iterator();
    this.currIterator = Collections.emptyIterator();;
  }

  public int next() {
    hasNext();
    return (int) this.currIterator.next();
  }

  public boolean hasNext() {
    while (!this.currIterator.hasNext() && this.iterators.hasNext()) {
      this.currIterator = this.iterators.next();
    }
    return this.currIterator.hasNext();
  }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
