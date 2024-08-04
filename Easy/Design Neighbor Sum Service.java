class neighborSum {

    private static final int[][] ADJACENT_DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int[][] DIAGONAL_DIRS = {{1, -1}, {-1, 1}, {1, 1}, {-1, -1}};

    private final int[][] grid;
    private final int numRows;
    private final int numCols;
    private final Map<Integer, int[]> valueToCoordinateMap;

    public neighborSum(int[][] grid) {
        this.numRows = grid.length;
        this.numCols = grid[0].length;
        this.valueToCoordinateMap = new HashMap<>();
        this.grid = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                this.grid[i][j] = grid[i][j];
                this.valueToCoordinateMap.put(grid[i][j], new int[]{i, j});
            }
        }
    }
    
    public int adjacentSum(int value) {
        return calculateSum(valueToCoordinateMap.get(value), ADJACENT_DIRS);
    }
    
    public int diagonalSum(int value) {
        return calculateSum(valueToCoordinateMap.get(value), DIAGONAL_DIRS);
    }

    private int calculateSum(int[] coordinate, int[][] directions) {
        int sum = 0;
        for (int[] dir : directions) {
            int newX = dir[0] + coordinate[0];
            int newY = dir[1] + coordinate[1];
            if (newX >= 0 && newX < numRows && newY >= 0 && newY < numCols) {
                sum += grid[newX][newY];
            }
        }
        return sum;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
