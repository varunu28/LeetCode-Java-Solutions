class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int[][] prefix = new int[n][2];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            prefix[i][0] = (i == 0 ? 0 : prefix[i - 1][1]) + (c == '1' ? 1 : 0);
            prefix[i][1] = (i == 0 ? 0 : prefix[i - 1][0]) + (c == '0' ? 1 : 0);
        }
        int result = Math.min(prefix[n - 1][0], prefix[n - 1][1]);
        if (n % 2 == 1) {
            int[][] suffix = new int[n][2];
            for (int i = n - 1; i >= 0; i--) {
                char c = s.charAt(i);
                suffix[i][0] = (i == n - 1 ? 0 : suffix[i + 1][1]) + (c == '1' ? 1 : 0);
                suffix[i][1] = (i == n - 1 ? 0 : suffix[i + 1][0]) + (c == '0' ? 1 : 0);
            }
            for (int i = 0; i < n - 1; i++) {
                result = Math.min(result, prefix[i][0] + suffix[i + 1][0]);
                result = Math.min(result, prefix[i][1] + suffix[i + 1][1]);
            }
        }
        return result;
    }
}
