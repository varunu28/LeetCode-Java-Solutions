class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int start = 1;
        int end = 1000_000_0;
        int minSpeed = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(dist, mid, hour)) {
                minSpeed = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minSpeed;
    }
    
    private boolean isPossible(int[] dist, int speed, double hour) {
        double totalTime = 0.0;
        for (int i = 0; i < dist.length; i++) {
            double time = (double) dist[i] / (double) speed;
            totalTime += (i == dist.length - 1 ? time : Math.ceil(time));
        }
        return totalTime <= hour;
    }
}
