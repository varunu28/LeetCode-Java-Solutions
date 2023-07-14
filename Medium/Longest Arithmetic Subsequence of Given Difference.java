class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxValue = 0;
        for (int num : arr) {
            int endingSubLength = map.getOrDefault(num - difference, 0);
            map.put(num, endingSubLength + 1);
            maxValue = Math.max(maxValue, map.get(num));
        }
        return maxValue;
    }
}
