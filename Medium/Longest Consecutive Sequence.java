class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int maxLength = 0;
    for (int num : set) {
      if (!set.contains(num - 1)) {
        int currNum = num;
        int currentLength = 1;
        while (set.contains(currNum + 1)) {
          currNum++;
          currentLength++;
        }
        maxLength = Math.max(currentLength, maxLength);
      }
    }
    return maxLength;
  }
}
