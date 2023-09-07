class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long result = 0;
        long currSum = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int uniqueCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            frequencyMap.put(curr, frequencyMap.getOrDefault(curr, 0) + 1);
            if (frequencyMap.get(curr) == 1) {
                uniqueCount++;
            }
            currSum += curr;
            if (i >= k - 1) {
                if (uniqueCount >= m) {
                    result = Math.max(result, currSum);
                }
                int temp = nums.get(i - k + 1);
                frequencyMap.put(temp, frequencyMap.getOrDefault(temp, 0) - 1);
                if (frequencyMap.get(temp) == 0) {
                    uniqueCount--;
                }
                currSum -= temp;
            }
        }
        return result;
    }
}
