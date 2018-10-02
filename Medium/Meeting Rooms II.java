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
    public static int minMeetingRooms(Interval[] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        int i = 0;

        for (Interval interval : intervals) {
            start[i] = interval.start;
            end[i] = interval.end;

            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int slow = 0;
        int fast = 0;
        int count = 0;

        while (slow < intervals.length) {
            if (start[slow] >= end[fast]) {
                count--;
                fast++;
            }

            count++;
            slow++;
        }

        return count;
    }
    
    public static int minMeetingRoomsQueue(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> endTimes = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        endTimes.add(intervals[0].end);

        for (int i=1; i<intervals.length; i++) {
            if (intervals[i].start >= endTimes.peek()) {
                endTimes.poll();
            }

            endTimes.add(intervals[i].end);
        }

        return endTimes.size();
    }
}
