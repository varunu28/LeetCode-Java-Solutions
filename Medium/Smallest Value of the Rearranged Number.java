class Solution {
  public long smallestNumber(long num) {
    return num < 0 ?
        getArrangement(Math.abs(num), (o1, o2) -> (int) (o2 - o1), true) * -1 :
        getArrangement(num, (o1, o2) -> (int) (o1 - o2), false);
  }

  private long getArrangement(long num, Comparator<Long> comparator, boolean zeroAtEnd) {
    PriorityQueue<Long> pq = new PriorityQueue<>(comparator);
    long zeroMultiple = 1;
    while (num > 0) {
      long remainder = num % 10;
      if (remainder == 0) {
        zeroMultiple *= 10;
      } else {
        pq.add(remainder);
      }
      num /= 10;
    }
    long result = 0;
    if (!pq.isEmpty()) {
      result = result * 10 + pq.poll();
    }
    if (!zeroAtEnd) {
      result *= zeroMultiple;
    }
    while (!pq.isEmpty()) {
      result = result * 10 + pq.poll();
    }
    if (zeroAtEnd) {
      result *= zeroMultiple;
    }
    return result;
  }
}
