class Solution {
  public int beautySum(String s) {
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      int[] charFrequency = new int[26];
      for (int j = i; j < s.length(); j++) {
        charFrequency[s.charAt(j) - 'a']++;
        sum += getBeauty(charFrequency);
      }
    }
    return sum;
  }

  private int getBeauty(int[] charFrequency) {
    int min = Integer.MAX_VALUE ;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < 26; i++) {
      if (charFrequency[i] == 0) {
        continue;
      }
      min = Math.min(min, charFrequency[i]);
      max = Math.max(max, charFrequency[i]);
    }
    return max - min;
  }
}
