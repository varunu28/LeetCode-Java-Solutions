class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int meetingRooms = 0;
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
                pq.poll();
            }
            pq.add(interval);
            meetingRooms = Math.max(meetingRooms, pq.size());
        }
        return meetingRooms;
    }
}
