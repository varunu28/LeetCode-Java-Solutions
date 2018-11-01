class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        dp[0][0] = true;

        for (int i = 0; i <= s1.length(); i++){
            for (int j = 0; j <= s2.length(); j++){
                boolean s1Check = false;
                boolean s2Check = false;

                if (i > 0) {
                    s1Check = dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1);
                }

                if (j > 0) {
                    s2Check = dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1);
                }

                if (i>0 || j>0) {
                    dp[i][j] = s1Check || s2Check;
                }
            }
        }


        return dp[s1.length()][s2.length()];
    }
}
