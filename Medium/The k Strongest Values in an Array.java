class Solution {
  public int[] getStrongest(int[] arr, int k) {
    Arrays.sort(arr);
    int i = 0;
    int j = arr.length - 1;
    int idx = 0;
    int median = arr[(arr.length - 1) / 2];
    int[] res = new int[k];
    while (idx < k) {
      res[idx++] = (median - arr[i] > arr[j] - median) ? arr[i++] : arr[j--];
    }
    return res;
  }
}
