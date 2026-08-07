class Solution {
    public String smallestNumber(String num, long t) {
        long temp = t;
        for (int i = 2; i <= 9; i++) {
            while (temp % i == 0) {
                temp /= i;
            }
        }
        if (temp > 1) {
            return "-1";
        }
        int n = num.length();
        long[] remainder = new long[n + 1];
        remainder[0] = t;
        int pos = n - 1;
        char[] digits = num.toCharArray();
        for (int i = 0; i < n; i++) {
            if (digits[i] == '0') {
                pos = i;
                break;
            }
            remainder[i + 1] = remainder[i] / gcd(remainder[i], digits[i] - '0');
        }
        if (remainder[n] == 1) {
            return num;
        }
        for (int i = pos; i >= 0; i--) {
            while (++digits[i] <= '9') {
                long curr = remainder[i] / gcd(remainder[i], digits[i] - '0');
                int k = 9;
                for (int j = n - 1; j > i; j--) {
                    while (curr % k != 0) {
                        k--;
                    }
                    curr /= k;
                    digits[j] = (char) ('0' + k);
                }
                if (curr == 1) {
                    return new String(digits);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        long original = t;
        for (int i = 9; i > 1; i--) {
            while (original % i == 0) {
                result.append((char) ('0' + i));
                original /= i;
            }
        }
        int padding = Math.max(n + 1 - result.length(), 0);
        for (int i = 0; i < padding; i++) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
