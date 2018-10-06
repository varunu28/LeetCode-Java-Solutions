class LogSystem {

    List<LogEntry> logEntries;
    Map<String, Integer> granualityMap = new HashMap<>();
    String[] grans = "Year:Month:Day:Hour:Minute:Second".split(":");
    int[] gransIndex = {4,7,10,13,16,19};

    public LogSystem() {
        logEntries = new ArrayList<>();
        for (int i=0; i<grans.length; i++) {
            granualityMap.put(grans[i], gransIndex[i]);
        }
    }

    public void put(int id, String timestamp) {
        logEntries.add(new LogEntry(id, timestamp));
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> list = new ArrayList<>();
        Iterator<LogEntry> logIterator = logEntries.iterator();
        int substringEnd = granualityMap.get(gra);

        String start = s.substring(0, substringEnd);
        String end = e.substring(0, substringEnd);

        while (logIterator.hasNext()) {
            LogEntry entry = logIterator.next();
            String entryTimeStamp = entry.timestamp;

            if (entryTimeStamp.substring(0, substringEnd).compareTo(start) >= 0 &&
                entryTimeStamp.substring(0, substringEnd).compareTo(end) <= 0) {
                list.add(entry.id);
            }
        }

        return list;
    }
}

class LogEntry {
    int id;
    String timestamp;

    public LogEntry(int id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
