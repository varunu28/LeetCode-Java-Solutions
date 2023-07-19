class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[1]));
        int result = 0;
        int minEndTime = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= minEndTime) {
                minEndTime = end;
            } else {
                result++;
            }
        }
        return result;
    }
}
