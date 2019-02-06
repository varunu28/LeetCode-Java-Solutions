class Solution {
    int[] memo;
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        
        return helperDp(0, s);
    }
    
    private int helperDp(int idx, String s) {
        if (memo[idx] > -1) {
            return memo[idx];
        }
        
        int n = s.length();
        if (idx == n) {
            return memo[idx] = 1;
        }
        
        if (s.charAt(idx) == '0') {
            return memo[idx] = 0;
        }
        
        int temp = helperRecursive(idx + 1, s);
        memo[idx + 1] = temp;
        
        if (idx < n - 1 && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7'))) {
            memo[idx + 2] = helperRecursive(idx + 2, s);
            temp += memo[idx + 2];
        }
        
        return temp;
    }
    
    private int helperRecursive(int idx, String s) {
        int n = s.length();
        
        if (idx == n) {
            return 1;
        }
        
        if (s.charAt(idx) == '0') {
            return 0;
        }
        
        int temp = helperRecursive(idx + 1, s);
        
        if (idx < n - 1 && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7'))) {
            temp += helperRecursive(idx + 2, s);
        }
        
        return temp;
    }
}
