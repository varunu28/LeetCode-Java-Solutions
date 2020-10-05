class Solution {
  public int[] arrayRankTransform(int[] arr) {
    PriorityQueue<Integer> pq = Arrays.stream(arr).boxed()
        .collect(Collectors.toCollection(PriorityQueue::new));
    int rank = 1;
    Map<Integer, Integer> rankMap = new HashMap<>();
    while (!pq.isEmpty()) {
      int key = pq.poll();
      rankMap.put(key, rank++);
      while (!pq.isEmpty() && pq.peek() == key) {
        pq.poll();
      }
    }
    int[] ans = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      ans[i] = rankMap.get(arr[i]);
    }
    return ans;
  }
}
