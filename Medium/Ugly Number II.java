class Solution {
  public int nthUglyNumber(int n) {
    int[] arr = new int[n];
    arr[0] = 1;
    int idx2 = 0;
    int idx3 = 0;
    int idx5 = 0;
    int mul2 = 2;
    int mul3 = 3;
    int mul5 = 5;
    int ugly = arr[0];
    for (int i = 1; i < n; i++) {
      ugly = Math.min(mul2, Math.min(mul3, mul5));
      arr[i] = ugly;
      if (ugly == mul2) {
        idx2++;
        mul2 = arr[idx2] * 2;
      }
      if (ugly == mul3) {
        idx3++;
        mul3 = arr[idx3] * 3;
      }
      if (ugly == mul5) {
        idx5++;
        mul5 = arr[idx5] * 5;
      }
    }
    return ugly;
  }
}
