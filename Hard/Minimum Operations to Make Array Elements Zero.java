class Solution {
    public long minOperations(int[][] queries) {
        long result = 0;
        for (int[] query : queries) {
            long firstCount = countOperations(query[1]);
            long secondCount = countOperations(query[0] - 1);
            result += (firstCount - secondCount + 1) / 2;
        }
        return result;
    }

    private long countOperations(int num) {
        long count = 0;
        int idx = 1;
        int base = 1;
        while (base <= num) {
            int end = Math.min(base * 2 - 1, num);
            count += (long) ((idx + 1) / 2) * (end - base + 1);
            idx++;
            base *= 2;
        }
        return count;
    }
}
