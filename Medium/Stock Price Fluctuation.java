class StockPrice {
  Map<Integer, Integer> map;
  int mostRecentTimeStamp;
  PriorityQueue<int[]> minHeap;
  PriorityQueue<int[]> maxHeap;
  public StockPrice() {
    map = new HashMap<>();
    mostRecentTimeStamp = Integer.MIN_VALUE;
    minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
  }

  public void update(int timestamp, int price) {
    map.put(timestamp, price);
    mostRecentTimeStamp = Math.max(mostRecentTimeStamp, timestamp);
    minHeap.add(new int[]{price, timestamp});
    maxHeap.add(new int[]{price, timestamp});
  }

  public int current() {
    return map.get(mostRecentTimeStamp);
  }

  public int maximum() {
    return getUpdatedValueFromHeap(maxHeap);
  }

  public int minimum() {
    return getUpdatedValueFromHeap(minHeap);
  }
  
  private int getUpdatedValueFromHeap(PriorityQueue<int[]> heap) {
    int[] entry = heap.poll();
    while (entry[0] != map.get(entry[1])) {
      entry = heap.poll();
    }
    heap.add(entry);
    return entry[0];
  }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
