class TimeMap {

    /** Initialize your data structure here. */
    Map<String, List<Entry>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        return binarySearch(map.get(key), 0, map.get(key).size() - 1, timestamp);
    }

    private String binarySearch(List<Entry> entries, int left, int right, int timestamp) {
        int idx = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (entries.get(mid).timestamp == timestamp) {
                return entries.get(mid).value;
            }
            else if (entries.get(mid).timestamp > timestamp) {
                right = mid - 1;
            }
            else {
                idx = Math.max(idx, mid);
                left = mid + 1;
            }
        }
        
        return idx == Integer.MIN_VALUE ? "" : entries.get(idx).value;
    }
}

class Entry {
    String value;
    int timestamp;

    public Entry(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
