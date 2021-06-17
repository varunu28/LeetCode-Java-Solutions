class Solution {
  public int chalkReplacer(int[] chalk, int k) {
    int initialResult = chalkReplacerHelper(chalk, k);
    return initialResult != -1 ? initialResult
        : chalkReplacerHelper(chalk, k % Arrays.stream(chalk).sum());
  }

  private int chalkReplacerHelper(int[] chalk, int k) {
    for (int i = 0; i < chalk.length; i++) {
      if (k - chalk[i] < 0) {
        return i;
      }
      k -= chalk[i];
    }
    return -1;
  }
}
