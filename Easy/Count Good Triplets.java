class Solution {
  public int countGoodTriplets(int[] arr, int a, int b, int c) {
    int count = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (
            Math.abs(arr[i] - arr[j]) <= a && 
            Math.abs(arr[j] - arr[k]) <= b && 
            Math.abs(arr[k] - arr[i]) <= c
          ) {
            count++;  
          }
        }
      }
    }
    return count;
  }
}
