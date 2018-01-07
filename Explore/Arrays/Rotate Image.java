class Solution {
    public void rotate(int[][] matrix) {
        reverseUpDown(matrix, matrix.length, matrix[0].length);
        
        for (int i=0;i<matrix.length;i++) {
            for (int j=i+1;j<matrix[0].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public void reverseUpDown(int[][] matrix, int row, int col) {
        
        int i = 0;
        int j = row-1;
        
        while(i<j) {
            for (int k=0;k<matrix[0].length;k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
            i++;
            j--;
        }
    }
}
