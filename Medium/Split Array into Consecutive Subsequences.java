class Solution {
  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> appendMap = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int i : nums) {
      if (map.get(i) == 0) {
        continue;
      }
      else if (appendMap.getOrDefault(i, 0) > 0) {
        appendMap.put(i, appendMap.get(i) - 1);
        appendMap.put(i + 1, appendMap.getOrDefault(i + 1, 0) + 1);
      }
      else if (map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0) {
        map.put(i + 1, map.get(i + 1) - 1);
        map.put(i + 2, map.get(i + 2) - 1);
        appendMap.put(i + 3, appendMap.getOrDefault(i + 3, 0) + 1);
      }
      else {
        return false;
      }
      map.put(i, map.get(i) - 1);
    }
    return true;
  }
}
