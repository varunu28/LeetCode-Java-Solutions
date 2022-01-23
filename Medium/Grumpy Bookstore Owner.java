class Solution {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int totalSum = 0;
    int maxDiff = 0;
    int grumpySum = 0;
    for (int i = 0; i < customers.length; i++) {
      totalSum += grumpy[i] == 1 ? 0 : customers[i];
      grumpySum += grumpy[i] == 1 ? customers[i] : 0;
      if (i >= minutes) {
        grumpySum -= grumpy[i - minutes] == 1 ? customers[i - minutes] : 0;
      }
      maxDiff = Math.max(maxDiff, grumpySum);
    }
    return totalSum + maxDiff;
  }
}
