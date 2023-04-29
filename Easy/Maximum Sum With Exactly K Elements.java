class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        int score = 0;
        while (k-- > 0) {
            score += maxNum++;
        }
        return score;
    }
}
