class RLEIterator {
  
  int[] encoding;
  int currCounterIdx;

  public RLEIterator(int[] encoding) {
    this.encoding = encoding;
    this.currCounterIdx = 0;
  }

  public int next(int n) {
    while (n > 0) {
      while (this.encoding[this.currCounterIdx] == 0 && this.currCounterIdx + 2 < this.encoding.length) {
        this.currCounterIdx += 2;
      }
      if (this.encoding[this.currCounterIdx] == 0) {
        return -1;
      }
      int diff = Math.min(this.encoding[this.currCounterIdx], n);
      this.encoding[this.currCounterIdx] -= diff;
      n -= diff;
    }
    return this.encoding[this.currCounterIdx + 1];
  }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
