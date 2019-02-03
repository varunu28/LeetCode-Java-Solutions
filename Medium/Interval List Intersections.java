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
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int startA = 0;
        int startB = 0;
        int endA = A.length;
        int endB = B.length;
        
        List<Interval> intervals = new ArrayList<>();
        
        while (startA < endA && startB < endB) {
            if (A[startA].end < B[startB].start) {
                startA++;
                continue;
            }
            
            if (A[startA].start > B[startB].end) {
                startB++;
                continue;
            }
            
            int intervalStart = Math.max(A[startA].start, B[startB].start);
            int intervalEnd = Math.min(A[startA].end, B[startB].end);
            
            intervals.add(new Interval(intervalStart, intervalEnd));
            
            if (A[startA].end < B[startB].end) {
                startA++;
            }
            else {
                startB++;
            }
        }
        
        Interval[] ans = new Interval[intervals.size()];
        for (int i=0; i<ans.length; i++) {
            ans[i] = intervals.get(i);
        }
        
        return ans;
    }
}
