class Solution {
    public int countServers(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[] rowCount = new int[numRows];
        int[] colCount = new int[numCols];
        int numOfServers = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    numOfServers++;
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    if (rowCount[i] == 1 && colCount[j] == 1) {
                        numOfServers--;
                    }
                }
            }
        }
        return numOfServers;
    }
}
