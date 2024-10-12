class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            int c = Integer.compare(o1[0], o2[0]);
            if (c == 0) {
                return Integer.compare(o1[1], o2[1]);
            }
            return c;
        });
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
            max = Math.max(max, pq.size());
        }
        return max;
    }
}
