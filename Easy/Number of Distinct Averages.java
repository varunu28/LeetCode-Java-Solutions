class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> averages = new HashSet<>();
        int startIdx = 0;
        int endIdx = nums.length - 1;
        while (startIdx <= endIdx) {
            double total = (double) (nums[startIdx++] + nums[endIdx--]);
            averages.add(total / 2);
        }
        return averages.size();
    }
}
