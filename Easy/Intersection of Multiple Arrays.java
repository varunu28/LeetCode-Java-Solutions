import java.util.Map.Entry;


class Solution {
  public List<Integer> intersection(int[][] nums) {
    Map<Integer, Integer> counter = new HashMap<>();
    for (int[] num : nums) {
      for (int element : num) {
        counter.put(element, counter.getOrDefault(element, 0) + 1);
      }
    }
    return counter.entrySet()
      .stream()
      .filter(entry -> entry.getValue() == nums.length)
      .map(Entry::getKey)
      .sorted()
      .collect(Collectors.toList());
  }
}
