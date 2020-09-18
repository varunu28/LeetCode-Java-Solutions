class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0 || timeSeries.length == 0) {
            return 0;
        }

        int totalTime = 0;
        int beginTime = timeSeries[0];
        for (int time : timeSeries) {
            totalTime += (time < beginTime + duration ? time - beginTime : duration);
            beginTime = time;
        }
        
        return totalTime + duration;
    }
}
