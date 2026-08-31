class Solution {

    private static final int MOD = 1000_000_007;

    public int sumDecoded(long[] nums) {
        long sum = 0;
        for (long num : nums) {
            sum = (sum + decode(num)) % MOD;
        }
        return (int) sum;
    }

    private long decode(long num) {
        int width = (int) (num % 10);
        long d = num / 10;
        long temp = d;
        int digitCount = 0;
        while (temp > 0) {
            digitCount++;
            temp /= 10;
        }
        if (digitCount == 0) {
            digitCount = 1;
        }
        long divisor = 1;
        for (int i = 0; i < digitCount - width; i++) {
            divisor *= 10;
        }
        long x = d / divisor;
        long y = d % divisor;
        return calculatePower(x, y);
    }

    private long calculatePower(long x, long y) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            y /= 2;
        }
        return result;
    }
}
