/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return new int[]{-1};
        }

        int[] start = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<intervals.length; i++) {
            start[i] = intervals[i].start;
            map.put(intervals[i].start, i);
        }

        Arrays.sort(start);
        int[] ans = new int[intervals.length];
        for (int i=0; i<n; i++) {
            int end = intervals[i].end;
            int x = Arrays.binarySearch(start, end);
            if (x > 0) {
                ans[i] = map.get(end);
            }
            else if (-x > n) {
                ans[i] = -1;
            }
            else {
                ans[i] = map.get(start[-x-1]);
            }
        }

        return ans;
    }
}
