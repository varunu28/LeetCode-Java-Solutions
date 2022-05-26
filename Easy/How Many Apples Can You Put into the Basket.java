class Solution {
  public int maxNumberOfApples(int[] weight) {
    int[] counter = new int[1001];
    for (int w : weight) {
      counter[w]++;
    }
    int numberOfApples = 0;
    int totalWeight = 0;
    for (int i = 1; i < counter.length && totalWeight <= 5000; i++) {
      int count = counter[i];
      while (count-- > 0 && totalWeight + i <= 5000) {
        numberOfApples++;
        totalWeight += i;
      }
    }
    return numberOfApples;
  }
}
