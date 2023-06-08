class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0])
                .thenComparingInt(o -> o[1]));
        int idx = 0;
        List<int[]> result = new ArrayList<>();
        while (idx < intervals.length) {
            int start = intervals[idx][0];
            int end = intervals[idx][1];
            idx++;
            while (idx < intervals.length && intervals[idx][0] <= end) {
                end = Math.max(end, intervals[idx++][1]);
            }
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[][]{});
    }
}
