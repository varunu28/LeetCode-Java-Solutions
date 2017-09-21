class MapSum {

    /** Initialize your data structure here. */
    Map<String, Integer> map = new HashMap<String, Integer>();
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getKey();
            if (s.length() >= prefix.length() && s.substring(0,prefix.length()).equals(prefix)) {
                sum += entry.getValue();
            }
        }
        
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
