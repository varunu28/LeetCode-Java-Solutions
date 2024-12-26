class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int maxTime = 0;
        int resultIdx = 0;
        int prevTime = 0;
        for (int i = 0; i < events.length; i++) {
            int timePressed = events[i][1] - prevTime;
            if (timePressed > maxTime) {
                maxTime = timePressed;
                resultIdx = events[i][0];
            } else if (timePressed == maxTime && resultIdx > events[i][0]) {
                resultIdx = events[i][0];
            }
            prevTime = events[i][1];
        }
        return resultIdx;
    }
}
