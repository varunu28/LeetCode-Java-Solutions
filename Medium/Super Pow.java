class Solution {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int result = 1;
        for (int digit : b) {
            result = (powMod(result, 10) * powMod(a, digit)) % MOD; 
        }
        return result;
    }

    private int powMod(int base, int exp) {
        int result = 1;
        base %= MOD;
        for (int i = 0; i < exp; i++) {
            result = (result * base) % MOD;
        }
        return result;
    }
}
