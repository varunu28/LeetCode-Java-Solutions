class Solution {
    
    private static final int MOD = 1000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Queue<int[]> know = new LinkedList<>();
        Queue<int[]> share = new LinkedList<>();
        know.add(new int[]{1, 1});
        int knowCount = 1;
        int shareCount = 0;
        for (int i = 2; i <= n; i++) {
            if (!know.isEmpty() && know.peek()[0] == i - delay) {
                int[] first = know.remove();
                knowCount = (knowCount - first[1] + MOD) % MOD;
                shareCount = (shareCount + first[1]) % MOD;
                share.add(first);
            }
            if (!share.isEmpty() && share.peek()[0] == i - forget) {
                int[] first = share.remove();
                shareCount = (shareCount - first[1] + MOD) % MOD;
            }
            if (!share.isEmpty()) {
                knowCount = (knowCount + shareCount) % MOD;
                know.add(new int[]{i, shareCount});
            }
        }
        return (knowCount + shareCount) % MOD;
    }
}
