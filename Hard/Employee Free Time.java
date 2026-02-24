/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int lastIntervalEnd = -1;
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> intervals : schedule) {
            pq.addAll(intervals);
        } 
        while (!pq.isEmpty()) {
            Interval removed = pq.remove();
            if (lastIntervalEnd != -1 && removed.start - lastIntervalEnd > 0) {
                result.add(new Interval(lastIntervalEnd, removed.start));
            }
            int maxEnd = removed.end;
            while (!pq.isEmpty() && pq.peek().start <= maxEnd) {
                maxEnd = Math.max(maxEnd, pq.remove().end);
            }
            lastIntervalEnd = maxEnd;
        }
        return result;
    }
}
