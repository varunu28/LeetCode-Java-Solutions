class Solution {
    public int countCommas(int n) {
        // n >= 1000 contains 1 comma each & max range is upto 10^5 hence just figuring out numbers greater than or equal to 1000 suffices
        return Math.max(n - 999, 0);
    }
}
