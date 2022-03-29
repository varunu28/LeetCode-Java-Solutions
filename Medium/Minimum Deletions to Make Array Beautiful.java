class Solution {
  public int minDeletion(int[] nums) {
    int numOfDeletions = 0;
    int prevNum = -1;
    for (int num : nums) {
      if (num == prevNum) {
        numOfDeletions++;
      } else {
        prevNum = prevNum == -1 ? num : -1;
      }
    }
    return prevNum == -1 ? numOfDeletions : numOfDeletions + 1;
  }
}
