class Solution {

    private static final int MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        int result = 0;
        Map<Integer, Integer> leftFrequency = new HashMap<>();
        Map<Integer, Integer> rightFrequency = new HashMap<>();
        for (int num : nums) {
            rightFrequency.put(num, rightFrequency.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            rightFrequency.put(num, rightFrequency.getOrDefault(num, 0) - 1);
            int leftMultiple = leftFrequency.getOrDefault(num * 2, 0);
            int rightMultiple = rightFrequency.getOrDefault(num * 2, 0);
            result = (int) ((result + 1L * leftMultiple * rightMultiple) % MOD);
            leftFrequency.put(num, leftFrequency.getOrDefault(num, 0) + 1);
        }        
        return result;
    }
}
