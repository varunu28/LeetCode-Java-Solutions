class Solution {
  public int[] sumZero(int n) {
    int[] result = new int[n];
    int idx = 0;
    int half = n / 2;
    for (int i = -1 * half; i < 0; i++) {
      result[idx++] = i;
    }
    if (n % 2 != 0) {
      result[idx++] = 0;
    }
    for (int i = 1; i <= half; i++) {
      result[idx++] = i;
    }
    return result;
  }
}
