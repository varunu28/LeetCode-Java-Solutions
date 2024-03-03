class Solution {
    public int[] resultArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        result[start++] = nums[0];
        result[end--] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (result[start - 1] > result[end + 1]) {
                result[start++] = nums[i];
            } else {
                result[end--] = nums[i];
            }
        }
        int left = end + 1;
        int right = nums.length - 1;
        while (left < right) {
            int temp = result[left];
            result[left] = result[right];
            result[right] = temp;
            left++;
            right--;
        }
        return result;
    }
}
