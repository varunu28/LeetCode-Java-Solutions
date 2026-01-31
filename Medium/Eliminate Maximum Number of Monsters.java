class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            if (dist[i] % speed[i] == 0) {
                pq.add(dist[i] / speed[i]);
            } else {
                pq.add((dist[i] / speed[i]) + 1);
            }
        }
        int time = 0;
        while (!pq.isEmpty()) {
            time++;
            if (time > pq.peek()) {
                break;
            }
            pq.remove();
        }
        return dist.length - pq.size();
    }
}
