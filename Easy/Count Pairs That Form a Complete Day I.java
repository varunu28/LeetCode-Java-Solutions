class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int hour : hours) {
            count += map.getOrDefault((24 - hour % 24) % 24, 0);
            map.put(hour % 24, map.getOrDefault(hour % 24, 0) + 1);
        }
        return count;
    }
}
