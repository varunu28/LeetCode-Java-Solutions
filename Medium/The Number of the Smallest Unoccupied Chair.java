class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int c = o1[0] - o2[0];
            if (c == 0) {
                return o1[1] - o2[1];
            }
            return c;
        });
        for (int i = 0; i < times.length; i++) {
            pq.add(new int[]{times[i][0], times[i][1], i});
        }
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> emptyChairs = new PriorityQueue<>();
        int currChair = 0;
        while (!pq.isEmpty()) {
            int[] time = pq.poll();
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time[0]) {
                int[] chair = occupiedChairs.poll();
                emptyChairs.add(chair[1]);
            }
            if (time[2] == targetFriend) {
                return emptyChairs.isEmpty() ? currChair : emptyChairs.poll();
            }
            if (emptyChairs.isEmpty()) {
                occupiedChairs.add(new int[]{time[1], currChair});
                currChair++;
            } else {
                int chair = emptyChairs.poll();
                occupiedChairs.add(new int[]{time[1], chair});
            }
        }
        return -1;
    }
}
