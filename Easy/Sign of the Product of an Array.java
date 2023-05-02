class Solution {
    public int arraySign(int[] nums) {
        int negCount = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            negCount += num > 0 ? 0 : 1;
        }
        return negCount % 2 == 0 ? 1 : -1;
    }
}
