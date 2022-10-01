class Solution {
  public boolean equalFrequency(String word) {
    int[] frequency = new int[26];
    int maxFrequency = 0;
    for (char c : word.toCharArray()) {
      frequency[c - 'a']++;
      maxFrequency = Math.max(maxFrequency, frequency[c - 'a']);
    }
    int maxCount = 0;
    int maxMinusOneCount = 0;
    for (int i = 0; i < 26; i++) {
      if (frequency[i] == 0) {
        continue;
      }
      if (frequency[i] == maxFrequency) {
        maxCount++;
      }
      if (frequency[i] == maxFrequency - 1) {
        maxMinusOneCount++;
      }
      if (frequency[i] < maxFrequency - 1) {
        return false;
      }
    }
    return maxMinusOneCount == 1 || maxCount == 1 || (maxMinusOneCount == 0 && maxFrequency == 1);
  }
}
