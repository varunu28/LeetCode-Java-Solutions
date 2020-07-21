class Solution {
  public int numberOfSubstrings(String s) {
    int ans = 0;
    int[] count = new int[3];
    int start = 0;
    int end = 0;
    int n = s.length();
    while (end < n) {
      count[s.charAt(end) - 'a']++;
      while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
        count[s.charAt(start++) - 'a']--;
      }
      end++;
      ans += start;
    }
    return ans;
  }
}
