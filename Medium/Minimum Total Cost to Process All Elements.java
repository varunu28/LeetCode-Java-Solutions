class Solution {

    private static final int MOD = 1000_000_007;

    public int minimumCost(int[] nums, int k) {
        int resources = k;
        int cost = 1;
        long operations = 0;
        for (int num : nums) {
            if (resources < num) {
                long currOperations = (num - resources + k - 1l) / k;
                operations += currOperations;
                resources += currOperations * k;
            }
            resources -= num;
        }
        if (operations % 2 == 0) {
            return (int) (((operations / 2) % MOD) * ((operations + 1) % MOD) % MOD);
        }
        return (int) (((operations % MOD) * (((operations + 1) / 2) % MOD)) % MOD);
    }
}
