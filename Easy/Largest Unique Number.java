class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxVal = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                maxVal = Math.max(maxVal, key);
            }
        }

        return maxVal == Integer.MIN_VALUE ? -1 : maxVal;
    }
}
