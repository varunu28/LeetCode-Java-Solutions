class Solution {
  public int commonFactors(int a, int b) {
    int count = 0;
    int minNum = Math.min(a, b);
    for (int i = 1; i <= minNum / 2; i++) {
      if (a % i == 0 && b % i == 0) {
        count++;
      }
    }
    return count + (a % minNum == 0 && b % minNum == 0 ? 1 : 0);
  }
}
