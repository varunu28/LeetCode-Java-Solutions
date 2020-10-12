class Solution {
  public int minSteps(String s, String t) {
    int[] counterS = getFreqCounter(s);
    int[] counterT = getFreqCounter(t);
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (counterT[i] < counterS[i]) {
        count += counterS[i] - counterT[i];
      }
    }
    return count;
  }
  
  private int[] getFreqCounter(String s) {
    int[] counter = new int[26];
    for (char c : s.toCharArray()) {
      counter[c - 'a']++;
    }
    return counter;
  }
}
