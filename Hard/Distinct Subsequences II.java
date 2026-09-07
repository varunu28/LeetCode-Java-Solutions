class Solution {

    private static final int MOD = 1000_000_007;

    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] cache = new int[n + 1];
        cache[0] = 1;
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cache[i + 1] = (cache[i] * 2) % MOD;
            if (lastIndex.containsKey(s.charAt(i))) {
                cache[i + 1] -= cache[lastIndex.get(s.charAt(i))];
            }
            cache[i + 1] %= MOD;
            lastIndex.put(s.charAt(i), i);
        }
        cache[n]--;
        if (cache[n] < 0) {
            cache[n] += MOD;
        }
        return cache[n];
    }
}
