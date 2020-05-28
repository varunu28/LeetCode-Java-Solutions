class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      public int compare(Integer p1, Integer p2) {
        return map.get(p1) - map.get(p2);
      }
    });
    for (Integer key : map.keySet()) {
      pq.add(key);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = pq.poll();
    }
    return ans;
  }
}
