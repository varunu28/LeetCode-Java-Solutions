class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    pq.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    while (k-- > 1) {
      pq.poll();
    }
    return pq.poll();
  }
}
