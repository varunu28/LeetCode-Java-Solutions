class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int start = 0;
        int end = tokens.length - 1;
        int numOfPoints = 0;
        int maxPoint = 0;

        while (start <= end) {
            if (P >= tokens[start]) {
                P -= tokens[start];
                start++;
                numOfPoints++;
            }
            else {
                if (numOfPoints > 0) {
                    numOfPoints--;
                    P += tokens[end];
                    end--;
                }
                else {
                    break;
                }
            }

            maxPoint = Math.max(numOfPoints, maxPoint);
        }

        return maxPoint;
    }
}
