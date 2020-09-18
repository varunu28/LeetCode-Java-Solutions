class UndergroundSystem {
  Map<Integer, String> checkInMap;
  Map<String, Integer> timeMap;
  Map<String, Integer> countMap;
  public UndergroundSystem() {
    checkInMap = new HashMap<>();
    timeMap = new HashMap<>();
    countMap = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    checkInMap.put(id, stationName + "," + t);
  }

  public void checkOut(int id, String stationName, int t) {
    String val = checkInMap.get(id);
    String prevStationName = val.split(",")[0];
    int prevTime = Integer.parseInt(val.split(",")[1]);
    String key = prevStationName + "|" + stationName;
    timeMap.put(key, timeMap.getOrDefault(key, 0) + t - prevTime);
    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
  }

  public double getAverageTime(String startStation, String endStation) {
    String key = startStation + "|" + endStation;
    return ((double) timeMap.get(key)) / countMap.get(key);
  }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
