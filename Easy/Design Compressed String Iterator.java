class StringIterator {

  private Integer charIdx;
  private Integer currCount;
  private Integer counterIdx;
  private String s;

  public StringIterator(String compressedString) {
    this.s = compressedString;
    updateCurrCount();
  }

  public char next() {
    if (!hasNext()) {
      return ' ';
    }
    this.currCount--;
    return s.charAt(this.charIdx);
  }

  public boolean hasNext() {
    updateCurrCount();
    return this.currCount > 0;
  }
  
  private void updateCurrCount() {
    if (this.currCount != null && this.currCount == 0) {
      this.charIdx = this.counterIdx;
      this.counterIdx = this.charIdx + 1;
    }
    if (this.currCount == null) {
      this.charIdx = 0;
      this.counterIdx = this.charIdx + 1;
      this.currCount = 0;
    }
    if (this.currCount == 0) {
      while (this.counterIdx < this.s.length()
          && Character.isDigit(this.s.charAt(this.counterIdx))) {
        this.currCount =
            this.currCount * 10 + Character.getNumericValue(this.s.charAt(this.counterIdx++));
      }
    }
  }
}


/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
