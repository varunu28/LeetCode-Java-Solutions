class Solution {
  int[] arr;
  int counter = 0;
  Random r = new Random();
  public Solution(int[] w) {
    arr = new int[w.length];
    counter += w[0];
    arr[0] = w[0];
    for (int i = 1; i < w.length; i++) {
      arr[i] = arr[i - 1] + w[i];
      counter += w[i];
    }
  }

  public int pickIndex() {
    int idx = r.nextInt(counter) + 1;
    int ret = Arrays.binarySearch(arr, idx); 
    if(ret < 0) {
      ret = -ret - 1;
    }
    return ret;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
