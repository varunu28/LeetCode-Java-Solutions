class NumMatrix {
    int[][] dp;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) {
            dp = new int[0][0];
            return;
        }
        
        dp = new int[matrix.length][matrix[0].length];
        fillDpArray();
        
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
    }
    
    private void fillDpArray() {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += this.matrix[i][j];
                dp[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int currSum = 0;
        for (int i = row1; i <= row2; i++) {
            currSum += dp[i][col2];
            if (col1 != 0) {
                currSum -= dp[i][col1 - 1];
            }
        }   
        
        return currSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
