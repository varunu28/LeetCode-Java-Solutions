class Solution {
  public int minCost(String colors, int[] neededTime) {
    int totalTime = 0;
    int left = 0;
    int right = 0;
    while (right < colors.length()) {
      int currTotal = 0;
      int currMax = 0;
      while (left < neededTime.length && colors.charAt(right) == colors.charAt(left)) {
        currTotal += neededTime[left];
        currMax = Math.max(currMax, neededTime[left]);
        left++;
      }
      totalTime += currTotal - currMax;
      right = left;
    }
    return totalTime;
  }
}
