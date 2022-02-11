class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    Map<Integer, List<Integer>> frequencyToValueMap = new HashMap<>();
    for (Integer key : map.keySet()) {
      frequencyToValueMap.computeIfAbsent(map.get(key), j -> new ArrayList<>()).add(key);
    }
    List<Integer> result = new ArrayList<>();
    for (int i = nums.length; i >= 0 && result.size() < k; i--) {
      List<Integer> values = frequencyToValueMap.getOrDefault(i, new ArrayList<>());
      if (result.size() + values.size() <= k) {
        result.addAll(values);
      } else {
        int idx = 0;
        while (result.size() < k) {
          result.add(values.get(idx++));
        }
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
