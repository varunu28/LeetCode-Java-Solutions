class Solution {
    public int distinctSubseqII(String s) {
        long[] occurenceIndx = new long[26];
        long MOD = 1000000007;
        
        for (char c : s.toCharArray()) {
            occurenceIndx[c - 'a'] = Arrays.stream(occurenceIndx).sum() % MOD + 1;
        }

        return (int) (Arrays.stream(occurenceIndx).sum() % MOD);
    }
}
