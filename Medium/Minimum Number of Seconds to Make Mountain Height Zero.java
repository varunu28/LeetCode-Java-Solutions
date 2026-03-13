class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int time : workerTimes) {
            pq.add(new long[]{time, time, 1}); // {current time, original time, iteration count}
        }
        long result = 0;
        for (int i = 0; i < mountainHeight; i++) {
            long[] removed = pq.poll();
            result = removed[0];
            long currTime = removed[0];
            long originalTime = removed[1];
            long iteration = removed[2];
            pq.add(new long[]{currTime + originalTime * (iteration + 1), originalTime, iteration + 1});
        }
        return result;
    }
}
