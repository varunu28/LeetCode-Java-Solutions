class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            startTime[i] = jobs[i][0];
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findMaxProfit(jobs, startTime, 0, n, dp);
    }

    private int findMaxProfit(int[][] jobs, int[] startTime, int position, int n, int[] dp) {
        if (position == n) {
            return 0;
        }
        if (dp[position] != -1) {
            return dp[position];
        }
        int nextPosition = binarySearch(startTime, jobs[position][1]);
        return dp[position] = Math.max(
            findMaxProfit(jobs, startTime, position + 1, n, dp), // skip executing current job
            jobs[position][2] + findMaxProfit(jobs, startTime, nextPosition, n, dp) // execute current job & move to next position
        );
    }

    private static int binarySearch(int[] startTime, int endTime) {
        int left = 0;
        int right = startTime.length - 1;
        int nextPosition = startTime.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (startTime[mid] >= endTime) {
                nextPosition = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nextPosition;
    }
}
