class Solution {
  public boolean isPossible(int[] target) {
    if (target.length == 1) {
      return target[0] == 1;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    int sum = 0;
    for (int num : target) {
      sum += num;
      pq.add(num);
    }
    int n = target.length;
    while (pq.peek() > 1) {
      int largest = pq.poll();
      int remaining = sum - largest;
      if (remaining == 1) {
        return true;
      }
      int delta = largest % remaining;
      if (delta == 0 || delta == largest) {
        return false;
      }
      pq.add(delta);
      sum = sum - largest + delta;
    }
    return true;
  }
}
