class UndergroundSystem {
  
  private Map<String, Integer> totalTimeFromStartToEndStation;
  private Map<String, Integer> numberOfCustomersFromStartToEndStation;
  private Map<Integer, Integer> customerIdToStartTime;
  private Map<Integer, String> customerIdToStartStation;
  
  public UndergroundSystem() {
    this.totalTimeFromStartToEndStation = new HashMap<>();
    this.numberOfCustomersFromStartToEndStation = new HashMap<>();
    this.customerIdToStartTime = new HashMap<>();
    this.customerIdToStartStation = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    this.customerIdToStartTime.put(id, t);
    this.customerIdToStartStation.put(id, stationName);
  }

  public void checkOut(int id, String stationName, int t) {
    int totalTime = t - this.customerIdToStartTime.get(id);
    String key = this.customerIdToStartStation.get(id) + "|" + stationName;
    this.totalTimeFromStartToEndStation.put(key, this.totalTimeFromStartToEndStation.getOrDefault(key, 0) + totalTime);
    this.numberOfCustomersFromStartToEndStation.put(key, this.numberOfCustomersFromStartToEndStation.getOrDefault(key, 0) + 1);
  }

  public double getAverageTime(String startStation, String endStation) {
    String key = startStation + "|" + endStation;
    return this.totalTimeFromStartToEndStation.get(key) / (double) (this.numberOfCustomersFromStartToEndStation.get(key));
   }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
