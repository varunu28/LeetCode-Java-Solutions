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
    public static List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() == 1) {
            return intervals;
        }

        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0) {
            return ans;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int i = 0;
        Interval prevInterval = null;

        List<Interval> temp = new ArrayList<>(intervals);

        for (Interval interval : temp) {
            if (i == 0) {
                prevInterval = interval;
                i++;
                continue;
            }

            if (interval.start <= prevInterval.end) {
                if (interval.end >= prevInterval.end) {
                    prevInterval.end = interval.end;
                }

                intervals.remove(interval);
            }
            else {
                prevInterval = interval;
            }
        }

        return intervals;
    }
}
