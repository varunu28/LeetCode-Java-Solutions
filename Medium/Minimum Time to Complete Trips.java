class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 1;
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
        }
        long left = 1;
        long right = (long) maxTime * totalTrips;
        while (left < right) {
            long mid = (left + right) / 2;
            if (isPossible(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean isPossible(int[] time, long totalTime, int totalTrips) {
        long actualTrips = 0;
        for (int t : time) {
            actualTrips += totalTime / t;
        }
        return actualTrips >= totalTrips;
    }
}
