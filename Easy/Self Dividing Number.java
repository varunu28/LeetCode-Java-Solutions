class Solution {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> ans = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      if (isSelfDivisible(i)) {
        ans.add(i);
      }
    }
    return ans;
  }
  
  private boolean isSelfDivisible(int num) {
    int copy = num;
    while (copy > 0) {
      int rem = copy % 10;
      copy /= 10;
      if (rem == 0 || num % rem != 0) {
        return false;
      }
    }
    return true;
  }
}
