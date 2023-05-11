class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length][nums2.length];
        return helper(nums1, 0, nums2, 0, dp);
    }
    
    private int helper(int[] nums1, int idxOne, int[] nums2, int idxTwo, Integer[][] dp) {
        if (idxOne == nums1.length || idxTwo == nums2.length) {
            return 0;
        }
        if (dp[idxOne][idxTwo] != null) {
            return dp[idxOne][idxTwo];
        }
        if (nums1[idxOne] == nums2[idxTwo]) {
            return dp[idxOne][idxTwo] = 1 + helper(nums1, idxOne + 1, nums2, idxTwo + 1, dp);
        }
        return dp[idxOne][idxTwo] = Math.max(
            helper(nums1, idxOne, nums2, idxTwo + 1, dp), 
            helper(nums1, idxOne + 1, nums2, idxTwo, dp));
    }
}
