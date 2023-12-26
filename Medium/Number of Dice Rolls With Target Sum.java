class Solution {

    private static final int MOD = 1000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(n, k, target, map);
    }

    private int helper(int n, int k, int target, Map<Integer, Integer> map) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n == 0 || target == 0) {
            return 0;
        }
        int key = n * 1000 + target;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int result = 0;
        for (int i = 1; i <= k; i++) {
            if (target < i) {
                break;
            }
            result = (result + helper(n - 1, k, target - i, map)) % MOD;
        }
        map.put(key, result);
        return result;
    }
}
