class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }
        int[] dp = new int[days[days.length - 1]];
        return helper(days[days.length - 1], daySet, costs, dp);
    }
    
    private int helper(int currDay, Set<Integer> daySet, int[] costs, int[] dp) {
        if (currDay <= 0) {
            return 0;
        }
        if (dp[currDay - 1] != 0) {
            return dp[currDay - 1];
        }
        int result = 0;
        if (daySet.contains(currDay)) {
            int one = helper(currDay - 1, daySet, costs, dp) + costs[0];
            int seven = helper(currDay - 7, daySet, costs, dp) + costs[1];
            int thirty = helper(currDay - 30, daySet, costs, dp) + costs[2];
            result = Math.min(one, Math.min(seven, thirty));
        } else {
            result = helper(currDay - 1, daySet, costs, dp);
        }
        return dp[currDay - 1] = result;
    }
}
