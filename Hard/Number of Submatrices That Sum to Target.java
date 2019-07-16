class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < cols; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < rows; k++) {
                    sum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    res += map.getOrDefault(sum - target, 0);
                    
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        
        return res;
    }
}
