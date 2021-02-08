class Solution {
  public int maximumScore(int a, int b, int c) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    pq.addAll(Arrays.asList(a, b, c));
    int score = 0;
    while (pq.size() > 1) {
      int firstStoneCount = pq.remove();
      int secondStoneCount = pq.remove();
      if (firstStoneCount > 1) {
        pq.add(firstStoneCount - 1);
      }
      if (secondStoneCount > 1) {
        pq.add(secondStoneCount - 1);
      }
      score++;
    }
    return score;
  }
}
