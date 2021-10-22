class Solution {
  public String frequencySort(String s) {
    int[] freqMap = new int[62];
    int maxFrequency = 0;
    for (char c : s.toCharArray()) {
      int charIdx = getCharIndex(c);
      freqMap[charIdx]++;
      maxFrequency = Math.max(maxFrequency, freqMap[charIdx]);
    }
    List<Character>[] revMap = new List[maxFrequency + 1];
    for (int i = 0; i < 62; i++) {
      char c = getDecodedChar(i);
      int currFreq = freqMap[i];
      if (currFreq != 0) {
        if (revMap[currFreq] == null) {
          revMap[currFreq] = new ArrayList<>();
        }
        revMap[currFreq].add(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = maxFrequency; i > 0; i--) {
      if (revMap[i] != null) {
        List<Character> characterList = revMap[i];
        for (char c : characterList) {
          sb.append(String.valueOf(c).repeat(i));
        }
      }
    }
    return sb.toString();
  }

  private char getDecodedChar(int idx) {
    return (char) (idx < 26 ? 97 + idx : (idx >= 52 ? 48 + idx - 52 : 65 + idx - 26));
  }

  private int getCharIndex(char c) {
    return Character.isDigit(c) ? 52 + c - '0'
        : (Character.isUpperCase(c) ? c - 'A' + 26 : c - 'a');
  }
}
