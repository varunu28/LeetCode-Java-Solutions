class Solution {
    public int missingInteger(int[] nums) {
        int sequentialPrefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            }
            sequentialPrefixSum += nums[i];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        while (!set.add(sequentialPrefixSum)) {
            sequentialPrefixSum++;
        }
        return sequentialPrefixSum;
    }
}
