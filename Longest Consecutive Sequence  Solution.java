class Solution {
  public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxLength = 0;
    for (int num : nums) {
      if (map.containsKey(num)) {
        continue;
      }
      int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
      int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
      int sum = left + right + 1;
      maxLength = Math.max(maxLength, sum);
      map.put(num, sum);
      map.put(num - left, sum);
      map.put(num + right, sum);
    }
    return maxLength;
  }   
}
