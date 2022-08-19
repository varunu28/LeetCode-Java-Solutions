class Solution {
  public boolean isPossible(int[] nums) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
      if (o1[1] == o2[1]) {
        return (o1[1] - o1[0]) - (o2[1] - o2[0]);
      } 
      return o1[1] - o2[1];
    });
    for (int num : nums) {
      while (!pq.isEmpty() && pq.peek()[1] + 1 < num) {
        if (!isValidSubsequence(pq.poll())) {
          return false;
        }
      }
      if (pq.isEmpty() || pq.peek()[1] == num) {
        pq.add(new int[]{num, num});
      } else {
        int[] subsequence = pq.poll();
        pq.add(new int[]{subsequence[0], num});
      }
    }
    while (!pq.isEmpty()) {
      if (!isValidSubsequence(pq.poll())) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isValidSubsequence(int[] subsequence) {
    return subsequence[1] - subsequence[0] + 1 >= 3;
  }
}
