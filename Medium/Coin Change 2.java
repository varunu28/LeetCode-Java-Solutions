class Solution {
    public static int change(int amount, int[] coins) {
        int[] combinations = new int[amount+1];
        combinations[0] = 1;

        for (int coin : coins) {
            for (int i=coin; i<amount+1; i++) {
                combinations[i] += combinations[i-coin];
            }
        }

        return combinations[amount];
    }
}
