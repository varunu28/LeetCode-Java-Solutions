class Solution {
  public int maxIceCream(int[] costs, int coins) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.addAll(Arrays.stream(costs).boxed().collect(Collectors.toList()));
    int icecreamCount = 0;
    while (!pq.isEmpty() && (coins - pq.peek()) >= 0) {
      coins -= pq.poll();
      icecreamCount++;
    }
    return icecreamCount;
  }
}
