class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> lastIdx = new HashMap<>();
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (garbage[i].indexOf('M') != -1) {
                lastIdx.putIfAbsent('M', i);
            }
            if (garbage[i].indexOf('G') != -1) {
                lastIdx.putIfAbsent('G', i);
            }
            if (garbage[i].indexOf('P') != -1) {
                lastIdx.putIfAbsent('P', i);
            }
        }
        int totalTime = 0;
        for (int i = 0; i < garbage.length; i++) {
            int travelTime = i == 0 ? 0 : travel[i - 1];
            totalTime += garbage[i].length();
            totalTime += lastIdx.getOrDefault('P', -1) >= i ? travelTime : 0;
            totalTime += lastIdx.getOrDefault('M', -1) >= i ? travelTime : 0;
            totalTime += lastIdx.getOrDefault('G', -1) >= i ? travelTime : 0;
        }
        return totalTime;
    }
}
