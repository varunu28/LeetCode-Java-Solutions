class Solution {
  public boolean canConstruct(String s, int k) {
    if (s.length() < k) {
      return false;
    }
    int[] counter = new int[26];
    int numOfOddOccurence = 0;
    for (char c : s.toCharArray()) {
      counter[c - 'a']++;
      numOfOddOccurence += counter[c - 'a'] % 2 == 0 ? -1 : 1;
    }
    return numOfOddOccurence <= k;
  }   
}
