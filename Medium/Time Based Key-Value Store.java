class TimeMap {

  /** Initialize your data structure here. */
  Map<String, TreeMap<Integer, String>> map;
  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      TreeMap<Integer, String> tMap = new TreeMap<>();
      map.put(key, tMap);
    }
    map.get(key).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key)) {
      return "";
    }
    TreeMap<Integer, String> tMap = map.get(key);
    Integer lower = tMap.floorKey(timestamp);
    if (lower == null) {
      return "";
    }
    return tMap.get(lower);
  }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
