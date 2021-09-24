class Solution {
  public int tribonacci(int n) {
    int[] arr = new int[38];
    arr[1] = arr[2] = 1;
    for (int i = 3; i < 38; i++) {
      arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
    }
    return arr[n];
  }
}
