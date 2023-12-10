class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        int diff = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (Math.max(0, batteryPercentage - diff) > 0) {
                count++;
                diff++;
            }
        }
        return count;
    }
}
