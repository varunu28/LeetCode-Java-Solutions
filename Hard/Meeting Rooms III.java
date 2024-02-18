class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> ongoingMeetings = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] frequency = new int[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? (int) (o1[1] - o2[1]) : (int) (o1[0] - o2[0]));
        for (int i = 0; i < n; i++) {
            pq.add(new long[]{0, i});
        }
        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            while (pq.peek()[0] < startTime) {
                pq.add(new long[]{startTime, pq.poll()[1]});
            }
            long[] finishedMeeting = pq.poll();
            int room = (int) finishedMeeting[1];
            long endTime = finishedMeeting[0] + (meeting[1] - meeting[0]);
            frequency[room]++;
            pq.add(new long[]{endTime, room});
        }
        int maxCount = 0;
        int roomWithMaxCount = 0;
        for (int i = 0; i < n; i++) {
            if (frequency[i] > maxCount) {
                maxCount = frequency[i];
                roomWithMaxCount = i;
            }
        }
        return roomWithMaxCount;
    }
}
