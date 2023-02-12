class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long concatenatedValue = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            concatenatedValue += start == end ? nums[start] : Integer.parseInt(nums[start] + "" + nums[end]);
            start++;
            end--;
        }
        return concatenatedValue;
    }
}
