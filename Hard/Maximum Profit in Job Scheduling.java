class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Integer[] cache = new Integer[n];
        return dfs(0, jobs, cache);
    }
    
    private int dfs(int idx, int[][] jobs, Integer[] cache) {
        if (idx == jobs.length) {
            return 0;
        }
        if (cache[idx] != null) {
            return cache[idx];
        }
        int nextIdx = idx + 1;
        while (nextIdx < jobs.length && jobs[idx][1] > jobs[nextIdx][0]) {
            nextIdx++;
        }
        int jobScheduled = jobs[idx][2] + dfs(nextIdx, jobs, cache);
        int jobNotScheduled = dfs(idx + 1, jobs, cache);
        return cache[idx] = Math.max(jobScheduled, jobNotScheduled);
    }
}
