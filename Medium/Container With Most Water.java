class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int mul = end;
        int res = Integer.MIN_VALUE;

        while (end - start >= 1) {
            int temp = mul * Math.min(height[start], height[end]);
            res = Math.max(res, temp);

            if (height[start] < height[end]) {
                start++;
            }
            else {
                end--;
            }

            mul--;
        }

        return res;
    }
}
