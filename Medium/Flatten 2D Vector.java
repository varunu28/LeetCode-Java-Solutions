class Vector2D {
  int vectorIdx;
  int currIdx;
  int[][] v;
  public Vector2D(int[][] v) {
    vectorIdx = 0;
    currIdx = 0;
    this.v = v;
  }

  public int next() {
    hasNext();
    return v[vectorIdx][currIdx++];
  }

  public boolean hasNext() {
    while (vectorIdx < v.length) {
      if (currIdx < v[vectorIdx].length) {
        return true;
      }
      vectorIdx++;
      currIdx = 0;
    }
    return false;
  }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
