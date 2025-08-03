class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int result = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minEnd = Integer.MAX_VALUE;
        // Land ride first
        for (int i = 0; i < n; i++) {
            minEnd = Math.min(minEnd, landStartTime[i] + landDuration[i]);
        }
        for (int i = 0; i < m; i++) {
            result = Math.min(result, waterDuration[i] + Math.max(minEnd, waterStartTime[i]));
        }
        minEnd = Integer.MAX_VALUE;
        // Water ride first
        for (int i = 0; i < m; i++) {
            minEnd = Math.min(minEnd, waterStartTime[i] + waterDuration[i]);
        }
        for (int i = 0; i < n; i++) {
            result = Math.min(result, landDuration[i] + Math.max(minEnd, landStartTime[i]));
        }
        return result;
    }
}
