import java.util.Map.Entry;


class Solution {
  public List<Integer> findLonely(int[] nums) {
    Map<Integer, Long> map = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    return map.entrySet().stream()
        .filter(
            entry -> entry.getValue().equals(1L) && !map.containsKey(entry.getKey() + 1)
            && !map.containsKey(entry.getKey() - 1))
        .map(Entry::getKey)
        .collect(Collectors.toList());
  }
}
