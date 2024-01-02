class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        Integer[] dp = new Integer[1024];
        return minDistance(workers, bikes, 0, 0, dp);
    }

    private int minDistance(int[][] workers, int[][] bikes, int workerIdx, int mask, Integer[] dp) {
        if (workerIdx >= workers.length) {
            return 0;
        }
        if (dp[mask] != null) {
            return dp[mask];
        }
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            // if bike is available
            if ((mask & (1 << i)) == 0) {
                // assign the bike & traverse for remaining bikes
                distance = Math.min(distance, calculateManhattanDistance(workers[workerIdx], bikes[i]) + minDistance(workers, bikes, workerIdx + 1, mask | (1 << i), dp));
            }
        }
        return dp[mask] = distance;
    }

    private static int calculateManhattanDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
