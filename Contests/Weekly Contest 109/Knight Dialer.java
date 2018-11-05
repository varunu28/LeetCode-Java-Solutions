class Solution {
    public int knightDialer(int N) {
        int MOD = 1000000007;
        long[] counts = new long[10];
        Arrays.fill(counts, 1);
        long[] temp;

        for (int i=1; i<=N-1; i++) {
            temp = counts.clone();

            counts[0] = (temp[4] + temp[6]) % MOD;
            counts[1] = (temp[6] + temp[8]) % MOD;
            counts[2] = (temp[7] + temp[9]) % MOD;
            counts[3] = (temp[4] + temp[8]) % MOD;
            counts[4] = (temp[3] + temp[9] + temp[0]) % MOD;
            counts[5] = 0;
            counts[6] = (temp[1] + temp[7] + temp[0]) % MOD;
            counts[7] = (temp[2] + temp[6]) % MOD;
            counts[8] = (temp[1] + temp[3]) % MOD;
            counts[9] = (temp[2] + temp[4]) % MOD;
        }

        return (int)(Arrays.stream(counts).sum()%MOD);
    }
}
