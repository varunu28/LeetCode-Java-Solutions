class Solution {
  public int findKthPositive(int[] arr, int k) {
    int missCount = 0;
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i];
      int prev = i == 0 ? 0 : arr[i - 1];
      while (prev < (curr - 1)) {
        missCount++;
        prev++;
        if (missCount == k) {
          return prev;
        }
      }
    }
    int curr = arr[arr.length - 1];
    while (missCount < k) {
      curr++;
      missCount++;
    }
    return curr;
  }
}
