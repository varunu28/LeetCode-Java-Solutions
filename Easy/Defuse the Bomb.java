class Solution {
  public int[] decrypt(int[] code, int k) {
    int n = code.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (k > 0) {
        for (int j = i + 1; j < i + k + 1; j++) {
          result[i] += code[j % n];
        }
      } else if (k < 0) {
        for (int j = i - 1; j > i + k - 1; j--) {
          result[i] += code[(j + n) % n];
        }
      }
    }
    return result;
  }
}
