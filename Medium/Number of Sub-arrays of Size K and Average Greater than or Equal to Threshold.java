class Solution {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int sum = 0;
    int start = 0;
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (i - start + 1 == k) {
        if ((double) sum / k >= threshold) {
          count++;
        }
        sum -= arr[start++]; 
      }
    }
    return count;
  }
}
