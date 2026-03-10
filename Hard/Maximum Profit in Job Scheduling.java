class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findMaxProfit(jobs, 0, n, dp);
    }

    private int findMaxProfit(int[][] jobs, int position, int n, int[] dp) {
        if (position == n) {
            return 0;
        }
        if (dp[position] != -1) {
            return dp[position];
        }
        int nextPosition = binarySearch(jobs, jobs[position][1]);
        return dp[position] = Math.max(
            findMaxProfit(jobs, position + 1, n, dp), // skip executing current job
            jobs[position][2] + findMaxProfit(jobs, nextPosition, n, dp) // execute current job & move to next position
        );
    }

    /**
    Binary search to figure out which job to start after the current job finishes
    */
    private static int binarySearch(int[][] jobs, int endTime) {
        int left = 0;
        int right = jobs.length - 1;
        int nextPosition = jobs.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (jobs[mid][0] >= endTime) {
                nextPosition = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nextPosition;
    }
}
