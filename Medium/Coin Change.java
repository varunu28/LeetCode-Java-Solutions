class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, max);
        cache[0] = 0;

        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] <= i) {
                    cache[i] = Math.min(cache[i], cache[i - coins[j]] + 1);
                }
            }
        }

        return cache[amount] > amount ? -1 : cache[amount];
    }
}
