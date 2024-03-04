class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int currScore = 0;
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right) {
            if (power >= tokens[left]) {
                currScore++;
                power -= tokens[left++];
            } else {
                if (currScore == 0) {
                    break;
                }
                currScore--;
                power += tokens[right--];
            }
            score = Math.max(score, currScore);
        }
        return score;
    }
}
