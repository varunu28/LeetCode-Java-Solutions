class Solution {
    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ans = new int[nums.length];
        int start = 0;
        int end = nums.length-1;

        int index = a >= 0 ? end : start;

        while (start <= end){
            if (a >= 0) {
                ans[index--] = getQuad(nums[start], a, b, c) >= getQuad(nums[end], a, b, c) ? getQuad(nums[start++], a, b, c) : getQuad(nums[end--], a, b, c);
            }
            else {
                ans[index++] = getQuad(nums[start], a, b, c) >= getQuad(nums[end], a, b, c) ? getQuad(nums[end--], a, b, c) : getQuad(nums[start++], a, b, c);
            }
        }

        return ans;
    }

    private static int getQuad(int num, int a, int b, int c) {
        return a *(num * num) + b * num + c;
    }
}
