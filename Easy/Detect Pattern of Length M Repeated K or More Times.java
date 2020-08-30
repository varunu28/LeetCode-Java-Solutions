class Solution {
  public boolean containsPattern(int[] arr, int m, int k) {
    Queue<Integer> queue = new LinkedList<>();
    int count = 0;
    int freq = 1;
    for (int i = 0; i < arr.length; i++) {
      if (i >= m) {
        if (arr[i] == queue.poll()) {
          count++;
          if (count == m) {
            freq++;
            count = 0;
          }
          if (freq == k) {
            return true;
          }
        }
        else {
          count = 0;
          freq = 1;
        }
      }
      queue.add(arr[i]);
    }
    return false;
  }
}
