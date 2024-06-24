class Solution {
    public double minimumAverage(int[] nums) {
        double minAverage = Double.MAX_VALUE;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            double average = (nums[left] + nums[right]) / 2.0;
            minAverage = Math.min(minAverage, average);
            left++;
            right--;
        }
        return minAverage;
    }
}
