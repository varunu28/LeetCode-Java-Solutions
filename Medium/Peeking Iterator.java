// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
  Integer nextElement;
  Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    updateNext();
	}
  
  private void updateNext() {
    nextElement = iterator.hasNext() ? iterator.next() : null;
  }
	
  // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
    return nextElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
    Integer returnValue = nextElement;
    updateNext();
    return returnValue;
	}
	
	@Override
	public boolean hasNext() {
	  return nextElement != null;
	}
}
