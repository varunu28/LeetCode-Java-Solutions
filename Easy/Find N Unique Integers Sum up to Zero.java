class Solution {
  public int[] sumZero(int n) {
    int[] arr = new int[n];
    int idx = 0;
    int num = n / 2;
    while (idx < n / 2) {
      arr[idx++] = num * -1;
      num--;
    }
    if (n % 2 != 0) {
      arr[idx++] = 0;
    }
    num = n / 2;
    while (idx < n) {
      arr[idx++] = num;
      num--;
    }
    return arr;
  }
}
