class Solution {
  public int findDuplicate(int[] nums) {
    int tortoise = nums[0];
    int hare = nums[0];
    while(true) {
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
      if (tortoise == hare) {
        break;
      }
    }
    int p1 = nums[0];
    int p2 = tortoise;
    while (p1 != p2) {
      p1 = nums[p1];
      p2 = nums[p2];
    }
    return p1;
  }
}
