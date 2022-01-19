public class ZigzagIterator {

  private final List<Integer> listOne;
  private final List<Integer> listTwo;
  int idxOne;
  int idxTwo;
  boolean pickFromListOne;
  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    this.listOne = v1;
    this.listTwo = v2;
    this.idxOne = 0;
    this.idxTwo = 0;
    this.pickFromListOne = true;
  }

  public int next() {
    if ((pickFromListOne && idxOne < listOne.size()) || (!pickFromListOne
        && idxTwo == listTwo.size())) {
      pickFromListOne = !pickFromListOne;
      return listOne.get(idxOne++);
    }
    pickFromListOne = !pickFromListOne;
    return listTwo.get(idxTwo++);
  }

  public boolean hasNext() {
    return idxOne < listOne.size() || idxTwo < listTwo.size();
  }
}



/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
