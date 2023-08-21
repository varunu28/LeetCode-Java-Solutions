class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int start = 0;
        int end = nums.size() - 1;
        int count = 0;
        while (start < end) {
            int sum = nums.get(start) + nums.get(end);
            if (sum < target) {
                count += end - start;
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
}
