class Solution {
    public long distributeCandies(int n, int limit) {
        long result = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            // distribution not possible as we will have to allocate at least one child with 
            // more than limit candies
            if (n - i > 2 * limit) {
                continue;
            }
            result += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return result;
    }
}
