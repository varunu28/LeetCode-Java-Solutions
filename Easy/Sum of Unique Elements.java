import java.util.Map.Entry;

class Solution {
  public int sumOfUnique(int[] nums) {
    return Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
        .entrySet().stream().filter(e -> e.getValue().equals(1L)).map(
            Entry::getKey).reduce(0, Integer::sum);
  }
}
