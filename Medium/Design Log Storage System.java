class LogSystem {

    private static final Map<String, Integer> GRANULARITY_MAP = Map.of(
        "Year", 0,
        "Month", 1,
        "Day", 2,
        "Hour", 3,
        "Minute", 4,
        "Second", 5
    );

    private final TreeMap<Long, List<Integer>> map;

    public LogSystem() {
        this.map = new TreeMap<>();
    }
    
    public void put(int id, String timestamp) {
        int[] numerics = Arrays.stream(timestamp.split(":"))
        .mapToInt(Integer::parseInt)
        .toArray();
        map.computeIfAbsent(convert(numerics), _ -> new ArrayList<>()).add(id);
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> result = new ArrayList<>();
        long startTime = calculateGranularity(start, granularity, false);
        long endTime = calculateGranularity(end, granularity, true);
        for (List<Integer> ids : map.subMap(startTime, endTime).values()) {
            result.addAll(ids);
        }
        return result;
    }

    private long convert(int[] numerics) {
        numerics[1] = numerics[1] - (numerics[1] == 0 ? 0 : 1);
        numerics[2] = numerics[2] - (numerics[2] == 0 ? 0 : 1);
        return (numerics[0] - 1999L) * (31 * 12) * 24 * 60 * 60 + 
        numerics[1] * 31 * 24 * 60 * 60 + 
        numerics[2] * 24 * 60 * 60 + 
        numerics[3] * 60 * 60 + 
        numerics[4] * 60 + 
        numerics[5];
    }

    private long calculateGranularity(String s, String granularity, boolean end) {
        String[] result = {"1999", "00", "00", "00", "00", "00"};
        String[] splits = s.split(":");
        for (int i = 0; i <= GRANULARITY_MAP.get(granularity); i++) {
            result[i] = splits[i];
        }
        int[] numerics = Arrays.stream(result)
        .mapToInt(Integer::parseInt)
        .toArray();
        if (end) {
            numerics[GRANULARITY_MAP.get(granularity)]++;
        }
        return convert(numerics);
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
