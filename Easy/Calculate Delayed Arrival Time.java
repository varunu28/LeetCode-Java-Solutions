class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int newTime = arrivalTime + delayedTime;
        return newTime - (newTime >= 24 ? 24 : 0);
    }
}
