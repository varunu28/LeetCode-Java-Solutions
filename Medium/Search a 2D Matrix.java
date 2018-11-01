class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        if (target < matrix[0][0] || target > matrix[matrix.length-1][matrix[matrix.length-1].length - 1]) {
            return false;
        }
        
        int i=0;
        for (i=0; i<matrix.length-1; i++) {
            if (target >= matrix[i][0] && target < matrix[i+1][0]) {
                return binarySearch(matrix[i], 0, matrix[i].length-1, target);
            }
        }
        
        return binarySearch(matrix[i], 0, matrix[i].length-1, target);
    }
    
    private boolean binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] == target) {
                return true;
            }
            else if (arr[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return false;
    }
}
