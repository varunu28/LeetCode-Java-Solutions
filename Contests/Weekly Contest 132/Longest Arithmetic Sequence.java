class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        
        int res = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
        }
        
        for (int i = 1; i < A.length; i++) {
            int curr = A[i];
            for (int j = 0; j < i; j++) {
                int prev = A[j];
                int diff = curr - prev;
                
                int len = 2;
                
                if (dp[j].containsKey(diff)) {
                    len = dp[j].get(diff) + 1;
                }
                
                int currLen = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, Math.max(currLen, len));
                
                res = Math.max(res, dp[i].get(diff));
            }
        }
        
        return res;
    }
}
