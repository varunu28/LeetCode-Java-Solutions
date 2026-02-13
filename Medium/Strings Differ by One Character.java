class Solution {

    private static final long MOD = (long) Math.pow(10, 20) + 7;

    public boolean differByOne(String[] dict) {
        int n = dict[0].length();
        long[] wordHash = new long[dict.length];
        for (int i = 0; i < dict.length; i++) {
            for (int j = 0; j < n; j++) {
                wordHash[i] = (wordHash[i] * 26 + dict[i].charAt(j) - 'a') % MOD;
            }
        }
        Set<Long> set = new HashSet<>();
        long base = 1;
        for (int j = n - 1; j >= 0; j--) {
            set.clear();
            for (int i = 0; i < dict.length; i++) {
                long newHash = (wordHash[i] - base * (dict[i].charAt(j) - 'a')) % MOD;
                if (set.contains(newHash)) {
                    return true;
                }
                set.add(newHash);
            }
            base = base * 26 % MOD;
        }
        return false;
    }
}
