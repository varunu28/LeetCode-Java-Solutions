class MyCalendar {
    TreeMap<Integer, Integer> map;
    
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = map.lowerEntry(end);
        if (entry != null && entry.getValue() > start) {
            return false;
        }
        
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
