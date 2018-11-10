class Solution {
    public int projectionArea(int[][] grid) {
        int sum = 0;
        
        for (int i=0; i<grid.length; i++) {
            int maxRow = Integer.MIN_VALUE;
            int maxCol = Integer.MIN_VALUE;

            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    sum++;
                }

                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            
            sum += maxCol + maxRow;
        }

        return sum;
    }
}
