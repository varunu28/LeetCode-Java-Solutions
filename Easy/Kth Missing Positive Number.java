class Solution {
  public int findKthPositive(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i] - 1;
      int prev = i == 0 ? 0 : arr[i - 1];
      while (prev < curr) {
        k--;
        prev++;
        if (k == 0) {
          return prev;
        }
      }
    }
    int curr = arr[arr.length - 1];
    while (k-- > 0) {
      curr++;
    }
    return curr;
  }
}
