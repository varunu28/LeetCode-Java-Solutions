class Solution {
  public int minMaxGame(int[] nums) {
    Queue<Integer> queue = new LinkedList<>();
    for (int num : nums) {
      queue.add(num);
    }
    while (queue.size() > 1) {
      int size = queue.size();
      boolean even = true;
      for (int i = 0; i < size; i += 2) {
        if (even) {
          queue.add(Math.min(queue.remove(), queue.remove()));
        } else {
          queue.add(Math.max(queue.remove(), queue.remove()));
        }
        even = !even;
      }
    }
    return queue.remove();
  }
}
