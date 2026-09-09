class Solution {

    public long countCommas(long n) {
        long result = 0;
        for (long power = 1000; power <= n; power *= 1000) {
            result += n - power + 1;
        }
        return result;
    }
}
