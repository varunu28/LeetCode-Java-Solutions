class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n%2;
        n /=2;
        while (n>0) {
            if (n%2 == prev) return false;
            prev = n%2;
            n /= 2;
        }
        return true;
    }
}
