class Solution {
  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    int[] frequencyOne = getFrequencyArray(word1);
    int[] frequencyTwo = getFrequencyArray(word2);
    for (int i = 0; i < frequencyOne.length; i++) {
      if (frequencyOne[i] == 0 && frequencyTwo[i] != 0) {
        return false;
      }
    }
    Arrays.sort(frequencyOne);
    Arrays.sort(frequencyTwo);
    for (int i = 0; i < frequencyOne.length; i++) {
      if (frequencyOne[i] != frequencyTwo[i]) {
        return false;
      }
    }
    return true;
  }
  
  private int[] getFrequencyArray(String s) {
    int[] frequency = new int[26];
    for (char c : s.toCharArray()) {
      frequency[c - 'a']++;
    }
    return frequency;
  }
}
