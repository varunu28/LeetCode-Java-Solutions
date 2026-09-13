class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> numToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndexMap.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
        }
        int result = 0;
        for (Integer key : numToIndexMap.keySet()) {
            List<Integer> indices = numToIndexMap.get(key);
            if (indices.size() != 3) {
                continue;
            }
            if (indices.get(2) - indices.get(1) == indices.get(1) - indices.get(0)) {
                result++;
            }
        }
        return result;
    }
}
