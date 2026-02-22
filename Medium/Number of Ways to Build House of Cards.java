class Solution {
    public int houseOfCards(int n) {
        int maxTriangleCount = (n + 1) / 3;
        Integer[][] memo = new Integer[n + 1][maxTriangleCount + 2];
        return recurse(n, maxTriangleCount + 1, memo);
    }

    private int recurse(int cardsLeft, int prevRowTriangleCount, Integer[][] memo) {
        if (cardsLeft == 0) {
            return 1;
        }
        if (cardsLeft < 0) {
            return 0;
        }
        if (memo[cardsLeft][prevRowTriangleCount] != null) {
            return memo[cardsLeft][prevRowTriangleCount];
        }
        int count = 0;
        for (int triangle = 1; triangle < prevRowTriangleCount && (3 * triangle - 1) <= cardsLeft; triangle++) {
            count += recurse(cardsLeft - (3 * triangle - 1), triangle, memo);
        }
        return memo[cardsLeft][prevRowTriangleCount] = count;
    }
}
