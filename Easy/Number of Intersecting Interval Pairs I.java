class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intersect(intervals[i], intervals[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean intersect(int[] intervalOne, int[] intervalTwo) {
        return Math.max(intervalOne[0], intervalTwo[0]) <= Math.min(intervalOne[1], intervalTwo[1]);
    }
}
