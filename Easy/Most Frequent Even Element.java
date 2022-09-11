class Solution {
  public int mostFrequentEven(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (num % 2 == 0) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
    }
    int maxValue = 0;
    int maxKey = -1;
    for (Integer key : map.keySet()) {
      if (map.get(key) >= maxValue) {
        if (map.get(key) > maxValue) {
          maxKey = key;
        } else {
          maxKey = Math.min(maxKey, key);
        }
        maxValue = map.get(key);
      }
    }
    return maxKey;
  }
}
