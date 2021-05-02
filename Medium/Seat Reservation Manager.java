class SeatManager {

  PriorityQueue<Integer> pq;
  int count;

  public SeatManager(int n) {
    pq = new PriorityQueue<>();
    count = 1;
  }

  public int reserve() {
    if (pq.size() == 0) {
      return count++;
    }
    return pq.remove();
  }

  public void unreserve(int seatNumber) {
    pq.add(seatNumber);
  }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
