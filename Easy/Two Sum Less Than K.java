class Solution {
  public int twoSumLessThanK(int[] nums, int k) {
    int[] counter = new int[1001];
    for (int num : nums) {
      counter[num]++;
    }
    int result = -1;
    int left = 1;
    int right = 1000;
    while (left <= right) {
      if (left + right >= k || counter[right] == 0) {
        right--;
      } else {
        if (counter[left] > (left == right ? 1 : 0)) {
          result = Math.max(result, left + right);
        }
        left++;
      }
    }
    return result;
  }
}
