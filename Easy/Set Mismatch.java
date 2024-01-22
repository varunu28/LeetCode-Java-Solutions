class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (!set.add(nums[i - 1])) {
                result[0] = nums[i - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
