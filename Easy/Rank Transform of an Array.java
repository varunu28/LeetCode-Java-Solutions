class Solution {
  public int[] arrayRankTransform(int[] arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();
    int rank = 1;
    for (int num : arr) {
      pq.add(num);
    }
    while (!pq.isEmpty()) {
      int num = pq.poll();
      if (!map.containsKey(num)) {
        map.put(num, rank);
        rank++;
      }
    }
    int[] rankArr = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      rankArr[i] = map.get(arr[i]);
    }
    return rankArr;
  }
}
