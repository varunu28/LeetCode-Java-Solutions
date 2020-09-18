class Solution {
  public int countSubstrings(String s) {
    int N = s.length();
    int ans = 0;
    for (int center = 0; center <= 2 * N - 1; ++center) {
        int left = center / 2;
        int right = left + center % 2;
        while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
            ans++;
            left--;
            right++;
        }
    }
    return ans;
  }
}
