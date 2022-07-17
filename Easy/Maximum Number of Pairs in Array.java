class Solution {
  public int[] numberOfPairs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int[] result = new int[2];
    for (Integer key : map.keySet()) {
      result[0] += map.get(key) / 2;
      result[1] += map.get(key) % 2;
    }
    return result;
  } 
}
