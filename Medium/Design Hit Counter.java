class HitCounter {
  
  private Deque<int[]> record;
  private int count;
  
  public HitCounter() {
    this.record = new LinkedList<>();
    this.count = 0;
  }

  public void hit(int timestamp) {
    if (!record.isEmpty() && record.getLast()[0] == timestamp) {
      record.getLast()[1]++;
    } else {
      record.add(new int[]{timestamp, 1});
    }
    this.count++;
  }

  public int getHits(int timestamp) {
    while (!record.isEmpty() && timestamp - record.getFirst()[0] >= 300) {
      this.count -= record.removeFirst()[1];
    }
    return this.count;
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
