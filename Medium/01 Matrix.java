class Solution {
    int MAX_VALUE = 10001;
    public int[][] updateMatrix(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                
                matrix[i][j] = getDistance(matrix, i, j, visited);
            }
        }
        
        return matrix;
    }
    
    private int getDistance(int[][] matrix, int i, int j, int[][] visited) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || visited[i][j] == 1) {
            return MAX_VALUE;
        }
        
        if (i - 1 >= 0 && matrix[i - 1][j] == 0) {
            return 1;
        }
        
        if (j - 1 >= 0 && matrix[i][j - 1] == 0) {
            return 1;
        }
        
        if (i + 1 < matrix.length && matrix[i + 1][j] == 0) {
            return 1;
        }
        
        if (j + 1 < matrix[0].length && matrix[i][j + 1] == 0) {
            return 1;
        }
        
        visited[i][j] = 1;
        
        int down = getDistance(matrix, i+1, j, visited);
        int top = getDistance(matrix, i-1, j, visited);
        int left = getDistance(matrix, i, j-1, visited);
        int right = getDistance(matrix, i, j+1, visited);
        
        visited[i][j] = 0;
        
        return 1 + Math.min(Math.min(down, top), Math.min(left, right));
    }
}
