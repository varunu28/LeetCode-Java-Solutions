class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int newIdx = findIdx(i, nums[i], n);
            result[i] = nums[newIdx];
        }
        return result;
    }

    private int findIdx(int idx, int shift, int n) {
        // If idx + shift is positive then % n will give us the answer as any positive value incremented by n & then again mod n results in same value
        // Addition of n is to take care of negative value
        return (((idx + shift) % n) + n) % n;  
    }
}
