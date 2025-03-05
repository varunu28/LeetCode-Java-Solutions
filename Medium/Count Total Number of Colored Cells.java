class Solution {
    public long coloredCells(int n) {
        long count = 1;
        int increment = 4;
        while (n-- > 1) {
            count += increment;
            increment += 4;
        }
        return count;
    }
}
