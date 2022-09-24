class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] frequencies = new int[26];
    for (char task : tasks) {
      frequencies[task - 'A']++;
    }
    Arrays.sort(frequencies);
    int maxFrequency = frequencies[25];
    int idleTime = (maxFrequency - 1) * n;
    for (int i = frequencies.length - 2; i >= 0 && idleTime > 0; i--) {
      idleTime -= Math.min(maxFrequency - 1, frequencies[i]);
    }
    idleTime = Math.max(0, idleTime);
    return idleTime + tasks.length;
  }
}
