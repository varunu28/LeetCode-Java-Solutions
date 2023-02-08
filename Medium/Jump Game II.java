class Solution {
    public int jump(int[] nums) {
        int jumpCount = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jumpCount++;
        }
        return jumpCount;
    }
}
