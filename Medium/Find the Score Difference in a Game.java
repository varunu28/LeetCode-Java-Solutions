class Solution {
    public int scoreDifference(int[] nums) {
        int first = 0;
        int second = 0;
        boolean isFirst = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                isFirst = !isFirst;
            }
            if ((i + 1) % 6 == 0) {
                isFirst = !isFirst;
            }
            if (isFirst) {
                first += nums[i];
            } else {
                second += nums[i];
            }
        }
        return first - second;
    }
}
