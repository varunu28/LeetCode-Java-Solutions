class Solution {
  public int minSetSize(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        return map.get(o2) - map.get(o1);
      }
    });
    for (Integer key : map.keySet()) {
      pq.add(key);
    }
    int n = arr.length / 2;
    int currSize = 0;
    int count = 0;
    while (currSize < n) {
      currSize += map.get(pq.poll());
      count++;
    }
    return count;
  }
}
