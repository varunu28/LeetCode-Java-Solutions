class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxScore = -1;
        int maxScoreCandidate = -1;
        for (int divisor : divisors) {
            int currScore = 0;
            for (int num : nums) {
                currScore += num % divisor == 0 ? 1 : 0;
            }
            if (currScore > maxScore) {
                maxScore = currScore;
                maxScoreCandidate = divisor;
            } else if (currScore == maxScore) {
                maxScoreCandidate = Math.min(maxScoreCandidate, divisor);
            }
        }
        return maxScoreCandidate;
    }
}
