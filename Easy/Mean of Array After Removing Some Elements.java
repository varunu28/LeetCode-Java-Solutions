class Solution {
  public double trimMean(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    double sum = 0;
    for (int idx = n / 20; idx < n - n / 20; idx++) 
      sum += arr[idx];
    return sum / (n - n / 10);
  }
}
