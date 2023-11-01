class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int workerCount = workers.length;
        int bikeCount = bikes.length;
        PriorityQueue<WorkerBikePair> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < workerCount; i++) {
            for (int j = 0; j < bikeCount; j++) {
                priorityQueue.add(new WorkerBikePair(manhattanDistance(workers[i], bikes[j]), i, j));
            }
        }
        Set<Integer> bikeDone = new HashSet<>();
        int[] result = new int[workerCount];
        Arrays.fill(result, Integer.MIN_VALUE);
        while (!priorityQueue.isEmpty()) {
            WorkerBikePair removed = priorityQueue.remove();
            if (result[removed.workerIdx] == Integer.MIN_VALUE && !bikeDone.contains(removed.bikeIdx)) {
                result[removed.workerIdx] = removed.bikeIdx;
                bikeDone.add(removed.bikeIdx);
            }
        }
        return result;
    }

    private record WorkerBikePair(int manhattanDistance, int workerIdx, int bikeIdx) implements Comparable<WorkerBikePair> {
        @Override
        public int compareTo(WorkerBikePair o) {
            int c = manhattanDistance - o.manhattanDistance;
            if (c != 0) {
                return c;
            }
            c = workerIdx - o.workerIdx;
            return c != 0 ? c : bikeIdx - o.bikeIdx;
        }
    }

    private static int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
