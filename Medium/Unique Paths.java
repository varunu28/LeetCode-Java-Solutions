class Solution {

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        return getCount(arr, m, n);        
    }
    
    private int getCount(int[][] arr, int m, int n) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (i == 0 || j ==0) {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
        }
        
        return arr[m-1][n-1];
    }
}
