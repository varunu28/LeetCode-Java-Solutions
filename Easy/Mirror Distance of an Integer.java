class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private static int reverse(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }
}
