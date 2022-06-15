class Solution {
  public int lengthOfLIS(int[] nums) {
    List<Integer> subsequence = new ArrayList<>();
    subsequence.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      int currNum = nums[i];
      if (currNum > subsequence.get(subsequence.size() - 1)) {
        subsequence.add(currNum);
      } else {
        int idx = 0;
        while (currNum > subsequence.get(idx)) {
          idx++;
        }
        subsequence.set(idx, currNum);
      }
    }
    return subsequence.size();
  }
}
