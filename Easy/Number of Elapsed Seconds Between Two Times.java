class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return inSeconds(endTime) - inSeconds(startTime);
    }

    private int inSeconds(String time) {
        String[] splits = time.split(":");
        return Integer.parseInt(splits[0]) * 60 * 60 + Integer.parseInt(splits[1]) * 60 + Integer.parseInt(splits[2]);
    }
}
