class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : arrays) {
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) == arrays.length) {
                    result.add(num);
                }
            }
        }
        return result;
    }
}
