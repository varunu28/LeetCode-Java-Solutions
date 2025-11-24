class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remainder = n % 10;
            n /= 10;
            sum += remainder;
            if (remainder != 0) {
                sb.append(remainder);
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        long concatenated = Long.parseLong(sb.reverse().toString());
        return concatenated * sum;
    }
}
