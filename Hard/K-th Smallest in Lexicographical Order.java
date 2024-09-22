class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int count = countNumsWithPrefix(n, curr, curr + 1);
            if (count <= k) {
                curr++;
                k -= count;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private int countNumsWithPrefix(int n, long start, long end) {
        int count = 0;
        while (start <= n) {
            count += Math.min(n + 1, end) - start;
            start *= 10;
            end *= 10;
        }
        return count;
    }
}
