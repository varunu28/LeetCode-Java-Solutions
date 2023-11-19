class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> accessTimeEntries) {
        Map<String, List<TimeRecord>> map = new HashMap<>();
        for (List<String> entry : accessTimeEntries) {
            String employee = entry.get(0);
            String time = entry.get(1);
            map.computeIfAbsent(employee, k -> new ArrayList<>()).add(TimeRecord.buildTimeRecord(time));
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            List<TimeRecord> entries = map.get(key);
            if (entries.size() < 3) {
                continue;
            }
            Collections.sort(entries);
            for (int i = 0; i < entries.size() - 2; i++) {
                if (TimeRecord.areWithinSameHour(entries.get(i), entries.get(i + 2))) {
                    result.add(key);
                    break;
                }
            }
        }
        return result;
    }

    private record TimeRecord(int totalMinutes) implements Comparable<TimeRecord> {

        public static TimeRecord buildTimeRecord(String entry) {
            int hour = Integer.parseInt(entry.substring(0, 2));
            int min = Integer.parseInt(entry.substring(2));
            return new TimeRecord(hour * 60 + min);
        }

        public static boolean areWithinSameHour(TimeRecord startTime, TimeRecord endTime) {
            return endTime.totalMinutes - startTime.totalMinutes < 60;
        }

        @Override
        public int compareTo(TimeRecord o) {
            return this.totalMinutes - o.totalMinutes;
        }
    }
}
