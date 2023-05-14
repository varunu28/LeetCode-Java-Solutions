class Solution {
    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int score = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int maxNum = 0;
            for (int[] num : nums) {
                maxNum = Math.max(maxNum, num[i]);
            }
            score += maxNum;
        }
        return score;
    }
}
