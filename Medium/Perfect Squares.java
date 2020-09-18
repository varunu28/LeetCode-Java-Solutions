class Solution {
  Set<Integer> squareNums;
  public int numSquares(int n) {
    squareNums = new HashSet<>();
    for (int i = 1; i * i <= n; i++) {
      squareNums.add(i * i);
    }
    int count = 1;
    for (count = 1; count <= n; count++) {
      if (isDividedBy(n, count)) {
        return count;
      }
    }
    return count;
  }
  
  private boolean isDividedBy(int n, int count) {
    if (count == 1) {
      return squareNums.contains(n);
    }
    for (Integer squareNum : squareNums) {
      if (isDividedBy(n - squareNum, count - 1)) {
        return true;
      }
    }
    return false;
  }
}
