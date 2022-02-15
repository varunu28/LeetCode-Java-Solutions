class Vector2D {

  private int[][] vec;
  private int vecIdx;
  private int idx;

  public Vector2D(int[][] vec) {
    this.vec = vec;
    this.idx = 0;
    this.vecIdx = 0;
    updateIdx();
  }

  private void updateIdx() {
    if (this.vecIdx < this.vec.length && this.idx == this.vec[this.vecIdx].length) {
      this.idx = 0;
      this.vecIdx++;
    }
    while (this.vecIdx < this.vec.length && this.vec[this.vecIdx].length == 0) {
      this.vecIdx++;
    }
  }

  public int next() {
    int result = this.vec[this.vecIdx][this.idx++];
    updateIdx();
    return result;
  }

  public boolean hasNext() {
    return this.vecIdx < this.vec.length;
  }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
