class Solution {
  public int bagOfTokensScore(int[] tokens, int power) {
    int score = 0;
    Arrays.sort(tokens);
    int leftIdx = 0;
    int rightIdx = tokens.length - 1;
    int currScore = 0;
    while (leftIdx <= rightIdx) {
      if (power >= tokens[leftIdx]) {
        currScore++;
        power -= tokens[leftIdx++];
      } else {
        if (currScore == 0) {
          break;
        }
        currScore--;
        power += tokens[rightIdx--];
      }
      score = Math.max(score, currScore);
    }
    return score;
  }
}
