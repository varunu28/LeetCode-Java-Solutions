class Solution {
  public int findKthLargest(int[] nums, int k) {
    int[] counter = new int[20001];
    for (int num : nums) {
      counter[num + 10000]++;
    }
    for (int i = counter.length - 1; i >= 0; i--) {
      if (counter[i] < k) {
        k -= counter[i];
      } else {
        return i - 10000;
      }
    }
    return -1;
  }
}
