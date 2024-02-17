class Solution {
    public int maxOperations(int[] nums) {
        int score = -1;
        int operations = 0;
        for (int i = 0; i <= nums.length - 2; i += 2) {
            int currScore = nums[i] + nums[i + 1];
            if (score != -1 && score != currScore) {
                break;
            } 
            score = currScore;
            operations++;
        }
        return operations;
    }
}
