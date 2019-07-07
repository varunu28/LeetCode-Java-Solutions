class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] booking : bookings) {
            int tickets = booking[2];
            int from = booking[0];
            int to = booking[1];

            ans[from - 1] += tickets;
            if (to < n) {
                ans[to] -= tickets;
            }
        }

        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += ans[i];
            ans[i] = currSum;
        }

        return ans;
    }
}
