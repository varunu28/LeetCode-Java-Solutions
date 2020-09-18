class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] counter = new int[26];
    for (char task : tasks) {
      counter[task - 'A']++;
    }
    Arrays.sort(counter);
    int maxFrequency = counter[25];
    int idleTime = (maxFrequency - 1) * n;
    for (int i = counter.length - 2; i >= 0 && idleTime > 0; i--) {
      idleTime -= Math.min(maxFrequency - 1, counter[i]);
    }
    idleTime = Math.max(0, idleTime);
    return idleTime + tasks.length;
  }
}
