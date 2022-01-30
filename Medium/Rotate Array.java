class Solution {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    int count = 0;
    for (int i = 0; count < n; i++) {
      int currIdx = i;
      int prevValue = nums[i];
      do {
        int nextIdx = (currIdx + k) % n;
        int tempValue = nums[nextIdx];
        nums[nextIdx] = prevValue;
        prevValue = tempValue;
        currIdx = nextIdx;
        count++;
      } while (i != currIdx);
    }
  }
}
