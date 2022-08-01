class Solution {
  public int[] findPermutation(String s) {
    int n = s.length();
    int[] result = new int[n + 1];
    for (int i = 0; i < result.length; i++) {
      result[i] = i + 1;
    }
    int idx = 1;
    while (idx <= n) {
      int k = idx;
      while (idx <= n && s.charAt(idx - 1) == 'D') {
        idx++;
      }
      reverse(result, k - 1, idx);
      idx++;
    }
    return result;
  }
  
  private void reverse(int[] result, int start, int end) {
    for (int i = 0; i < (end - start) / 2; i++) {
      int temp = result[i + start];
      result[i + start] = result[end - i - 1];
      result[end - i - 1] = temp;
    }
  }
}
