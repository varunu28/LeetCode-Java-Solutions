class TimeMap {

  private Map<String, List<TimeStampValuePair>> map;
  
  public TimeMap() {
    this.map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    this.map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeStampValuePair(timestamp, value));
  }

  public String get(String key, int timestamp) {
    if (!this.map.containsKey(key)) {
      return "";
    }
    List<TimeStampValuePair> pairs = this.map.get(key);
    int left = 0;
    int right = pairs.size() - 1;
    int maxIdx = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (pairs.get(mid).timestamp <= timestamp) {
        maxIdx = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return maxIdx == -1 ? "" : pairs.get(maxIdx).value;
  }
  
  private class TimeStampValuePair {
    int timestamp;
    String value;
    
    public TimeStampValuePair(int timestamp, String value) {
      this.timestamp = timestamp;
      this.value = value;
    }
  }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
