class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int currSum = nums[low] + nums[high] + nums[i];
                if (currSum > 0 || (high < nums.length - 1 && nums[high] == nums[high + 1])) {
                    high--;
                } else if (currSum < 0 || (low > i + 1 && nums[low] == nums[low - 1])) {
                    low++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                }
                
            }
        }
        return result;
    }
}
