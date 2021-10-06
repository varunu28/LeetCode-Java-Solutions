class Solution {
  public int numOfPairs(String[] nums, String target) {
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    for (String num : nums) {
      if (target.startsWith(num)) {
        String end = target.substring(num.length());
        count += map.getOrDefault(end, 0);
      } 
      if (target.endsWith(num)) {
        String start = target.substring(0, target.length() - num.length());
        count += map.getOrDefault(start, 0);
      }
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    return count;
  }
}
