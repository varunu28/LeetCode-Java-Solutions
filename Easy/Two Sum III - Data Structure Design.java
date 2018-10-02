class TwoSum {

    /** Initialize your data structure here. */
    List<Integer> list;
    Map<Integer, Integer> map;
    public TwoSum() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        }
        else {
            map.put(number, 1);
            list.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num : list) {
            int diff = value - num;
            if (diff != num && map.containsKey(diff)) {
                return true;
            }
            
            if (diff == num && map.get(diff) > 1) {
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
