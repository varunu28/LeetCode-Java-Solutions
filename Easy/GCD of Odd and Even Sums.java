class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 1; i <= 2 * n; i++) {
            sumOdd += i % 2 != 0 ? i : 0;
            sumEven += i % 2 == 0 ? i : 0;
        }
        return gcd(sumOdd, sumEven);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
