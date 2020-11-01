class Solution {
  public int[] frequencySort(int[] nums) {
    Map<Integer, Long> counter = Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())
    );
    PriorityQueue<Integer> frequencyMinHeap = new PriorityQueue<>((o1, o2) -> {
      int c = (int) (counter.get(o1) - counter.get(o2));
      return c != 0 ? c : o2 - o1;
    });
    frequencyMinHeap.addAll(counter.keySet());
    int[] sortedByFrequency = new int[nums.length];
    for (int idx = 0; idx < sortedByFrequency.length;) {
      int value = frequencyMinHeap.poll();
      long count = counter.get(value);
      while (count-- > 0) {
        sortedByFrequency[idx++] = value;
      }
    }
    return sortedByFrequency;
  }
}
