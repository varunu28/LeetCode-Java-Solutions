class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> list = new ArrayList<>();
        int removeStart = toBeRemoved[0];
        int removeEnd = toBeRemoved[1];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            // Case 1: Overlap the removal interval. Skip this interval
            if (start >= removeStart && end <= removeEnd) {
                continue;
            }
            // Case 2 and 3: Completely miss out the removal interval either on left side or right side of number line.
            // Add the complete interval
            if ((start <= removeStart && end <= removeStart) ||
                (start >= removeEnd && end >= removeEnd)) {
                list.add(Arrays.asList(start, end));
                continue;
            }
            // Case 4: Interval partially overlaps on left side of removal interval on number line. 
            // Add the modified interval
            if (start <= removeStart) {
                int tempStart = Math.min(start, removeStart);
                int tempEnd = Math.max(start, removeStart);
                if (tempStart != tempEnd) {
                    list.add(Arrays.asList(tempStart, tempEnd));
                }
            }
            // Case 5: Interval partially overlaps on right side of removal interval on number line. 
            // Add the modified interval
            if (end >= removeEnd) {
                int tempStart = Math.min(end, removeEnd);
                int tempEnd = Math.max(end, removeEnd);
                if (tempStart != tempEnd) {
                    list.add(Arrays.asList(tempStart, tempEnd));
                }
            }
        }
        return list;
    }
}
