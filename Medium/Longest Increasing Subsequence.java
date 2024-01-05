class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subsequence = new ArrayList<>();
        subsequence.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > subsequence.get(subsequence.size() - 1)) {
                subsequence.add(nums[i]);
            } else {
                int idx = 0;
                while (nums[i] > subsequence.get(idx)) {
                    idx++;
                }
                subsequence.set(idx, nums[i]);
            }
        }
        return subsequence.size();
    }
}
