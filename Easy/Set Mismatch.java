import java.util.Map.Entry;

class Solution {
  public int[] findErrorNums(int[] nums) {
    HashMap<Integer, Long> frequencyMap = Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    return new int[]{
        frequencyMap.entrySet().stream().filter(entry -> entry.getValue().equals(2L))
            .map(Entry::getKey).findFirst().orElse(-1),
        IntStream.range(1, nums.length + 1).boxed().filter(key -> !frequencyMap.containsKey(key))
            .findFirst().orElse(-1)
    };
  }
}
