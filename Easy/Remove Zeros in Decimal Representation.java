class Solution {
    public long removeZeros(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            var remainder = n % 10;
            n /= 10;
            if (remainder > 0) {
                sb.append(remainder);
            }
        }
        return Long.parseLong(sb.reverse().toString());
    }
}
