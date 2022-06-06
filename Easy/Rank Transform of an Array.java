class Solution {
  public int[] arrayRankTransform(int[] arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : arr) {
      pq.add(num);
    }
    int rank = 1;
    Map<Integer, Integer> map = new HashMap<>();
    while (!pq.isEmpty()) {
      int removed = pq.poll();
      if (!map.containsKey(removed)) {
        map.put(removed, rank++);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = map.get(arr[i]);
    }
    return arr;
  }
}
