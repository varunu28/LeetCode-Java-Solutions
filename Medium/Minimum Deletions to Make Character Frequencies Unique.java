class Solution {
  public int minDeletions(String s) {
    int[] frequencies = new int[26];
    for (char c : s.toCharArray()) {
      frequencies[c - 'a']++;
    }
    Arrays.sort(frequencies);
    int expectedFrequency = frequencies[25];
    int numOfDeletions = 0;
    for (int i = 25; i >= 0; i--) {
      if (frequencies[i] == 0) {
        break;
      }
      if (frequencies[i] > expectedFrequency) {
        numOfDeletions += frequencies[i] - expectedFrequency;
      } else {
        expectedFrequency = frequencies[i];
      }
      if (expectedFrequency > 0) {
        expectedFrequency--;
      }
    }
    return numOfDeletions;
  } 
}
