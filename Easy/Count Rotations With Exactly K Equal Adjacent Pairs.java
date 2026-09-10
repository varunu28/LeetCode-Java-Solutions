class Solution {
    public int countRotations(String s, int k) {
        int total = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                total++;
            }
        }
        total += s.charAt(0) == s.charAt(n - 1) ? 1 : 0;
        if (k == total) {
            return n - total;
        }
        if (k == total - 1) {
            return total;
        }
        return 0;
    }
}
