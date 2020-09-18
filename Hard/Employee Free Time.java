/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.start - b.start);
        schedule.forEach(e -> pq.addAll(e));    
    
        Interval temp = pq.poll();
        while (!pq.isEmpty()) {
            if (temp.end < pq.peek().start) {
                ans.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll();
            }
            else {
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        
        return ans;
    }   
}
