class Solution {
  public int minSetSize(int[] arr) {
    Map<Integer, Long> frequencyMap = Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    int halfSize = arr.length / 2;
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        (o1, o2) -> (int) (frequencyMap.get(o2) - frequencyMap.get(o1)));
    pq.addAll(frequencyMap.keySet());
    int counter = 0;
    while (!pq.isEmpty() && halfSize > 0) {
      halfSize -= frequencyMap.get(pq.poll());
      counter++;
    }
    return counter;
  }
}
