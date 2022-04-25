// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
  private Iterator<Integer> iterator;
  private Integer topElement;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    populateTopElement();
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return this.topElement;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    Integer nextValue = this.topElement;
    populateTopElement();
    return nextValue;
  }

  @Override
  public boolean hasNext() {
    return this.topElement != null;
  }

  private void populateTopElement() {
    this.topElement = this.iterator.hasNext() ? this.iterator.next() : null;
  }
}
