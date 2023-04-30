class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = 0;
        int score2 = 0;
        int tenIndex1 = -1;
        int tenIndex2 = -1;
        for (int i = 0; i < player1.length; i++) {
            score1 += player1[i];
            score2 += player2[i];
            if (tenIndex1 != -1 && i - tenIndex1 <= 2) {
                score1 += player1[i];
            }
            if (tenIndex2 != -1 && i - tenIndex2 <= 2) {
                score2 += player2[i];
            }
            if (player1[i] == 10) {
                tenIndex1 = i;
            }
            if (player2[i] == 10) {
                tenIndex2 = i;
            }
        }
        return score1 > score2 ? 1 : (score1 == score2 ? 0 : 2);
    }
}
