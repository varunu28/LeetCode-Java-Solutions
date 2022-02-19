class Solution {
  public int minimumDeviation(int[] nums) {
    int currMinimum = Integer.MAX_VALUE;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
    for (int num : nums) {
      if (num % 2 != 0) {
        num *= 2;
      }
      currMinimum = Math.min(currMinimum, num);
      priorityQueue.add(num);
    }
    int deviation = Integer.MAX_VALUE;
    while (priorityQueue.peek() % 2 == 0) {
      int removed = priorityQueue.poll() / 2;
      currMinimum = Math.min(currMinimum, removed);
      priorityQueue.add(removed);
      deviation = Math.min(deviation, priorityQueue.peek() - currMinimum);
    }
    return deviation;
  }
}
