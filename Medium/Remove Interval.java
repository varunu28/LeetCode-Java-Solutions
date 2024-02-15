class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        int n = intervals.length;
        int removeStart = toBeRemoved[0];
        int removeEnd = toBeRemoved[1];
        for (int i = 0; i < n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            // complete overlap hence skipping complete interval
            if (currStart >= removeStart && currEnd <= removeEnd) {
                continue;
            }
            // no overlap hence adding complete interval
            if ((currStart <= removeStart && currEnd <= removeStart) || (currStart >= removeEnd && currEnd >= removeEnd)) {
                result.add(List.of(currStart, currEnd));
                continue;
            } 
            // partial overlaps
            if (currStart <= removeStart) {
                int newStart = Math.min(currStart, removeStart);
                int newEnd = Math.max(currStart, removeStart);
                if (newStart != newEnd) {
                    result.add(List.of(newStart, newEnd));
                }
            }
            if (currEnd >= removeEnd) {
                int newStart = Math.min(currEnd, removeEnd);
                int newEnd = Math.max(currEnd, removeEnd);
                if (newStart != newEnd) {
                    result.add(List.of(newStart, newEnd));
                }
            }
        }
        return result;
    }
}
