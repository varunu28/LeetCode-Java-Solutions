class Solution {
  public int[] sortByBits(int[] arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        int c = Integer.bitCount(o1) - Integer.bitCount(o2);
        if (c != 0) {
          return c;
        }
        return o1 - o2;
      }
    });
    for (int num : arr) {
      pq.add(num);
    }
    int[] ans = new int[arr.length];
    int idx = 0;
    while (!pq.isEmpty()) {
      ans[idx++] = pq.poll();
    }
    return ans;
  }
}
