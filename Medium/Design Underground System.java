class UndergroundSystem {
    
    private final Map<Integer, StationTimePair> customerToCheckInMapping;
    private final Map<String, Integer> startEndStationTotalTimeMapping;
    private final Map<String, Integer> startEndStationCountMapping;

    public UndergroundSystem() {
        this.customerToCheckInMapping = new HashMap<>();
        this.startEndStationTotalTimeMapping = new HashMap<>();
        this.startEndStationCountMapping = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        StationTimePair pair = new StationTimePair(stationName, t);
        customerToCheckInMapping.put(id, pair);
    }
    
    public void checkOut(int id, String stationName, int t) {
        StationTimePair pair = customerToCheckInMapping.get(id);
        String key = pair.station() + "|" + stationName;
        int totalTime = t - pair.time();
        startEndStationTotalTimeMapping.put(key, startEndStationTotalTimeMapping.getOrDefault(key, 0) + totalTime);
        startEndStationCountMapping.put(key, startEndStationCountMapping.getOrDefault(key, 0) + 1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "|" + endStation;
        if (!startEndStationTotalTimeMapping.containsKey(key)) {
            return 0.0;
        }
        return ((double) startEndStationTotalTimeMapping.get(key)) / startEndStationCountMapping.get(key);
    }
    
    static record StationTimePair(String station, int time) {}
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
