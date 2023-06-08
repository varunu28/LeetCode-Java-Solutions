class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            int idx = findFirstNonNegativeIndex(row);
            count += idx == -1 ? 0 : (row.length - idx);
        }
        return count;
    }
    
    private int findFirstNonNegativeIndex(int[] row) {
        int start = 0;
        int end = row.length - 1;
        int idx = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (row[mid] < 0) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}
