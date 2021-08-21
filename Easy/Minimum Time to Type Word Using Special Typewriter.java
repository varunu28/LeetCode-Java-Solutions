class Solution {
  public int minTimeToType(String word) {
    int totalTime = 0;
    char currentChar = 'a';
    for (char c : word.toCharArray()) {
      int difference = Math.abs(c - currentChar);
      totalTime += 1 + Math.min(difference, 26 - difference);
      currentChar = c;
    }
    return totalTime;
  }
}
