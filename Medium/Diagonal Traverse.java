class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        
        int[] ans = new int[matrix.length * matrix[0].length];
        int idx = 0;
        
        int i = 0;
        boolean up = true;
        
		// First Triangle
        while (i < matrix.length) {
            int j = 0;
            int tempI = i;
            List<Integer> temp = new ArrayList<>();
            while (j < matrix[0].length && tempI >= 0) {
                temp.add(matrix[tempI][j]);
                j++;
                tempI--;
            }
            
            if (!up) {
                Collections.reverse(temp);
            }
            
            for (int num : temp) {
                ans[idx++] = num;
            }
            
            up = !up;
            i++;
        }
        
        if (matrix[i-1].length < 2) {
            return ans;
        }    
        
        i--;
        int j = 1;
		// Second Triangle
        while (j < matrix[0].length) {
            int k = i;
            List<Integer> temp = new ArrayList<>();
            int tempJ = j;
            while (k >= 0 && tempJ < matrix[0].length) {
                temp.add(matrix[k][tempJ]);
                k--;
                tempJ++;
            }
            
            if (!up) {
                Collections.reverse(temp);
            }
            
            for (int num : temp) {
                ans[idx++] = num;
            }
            
            up = !up;
            j++;
        }
        
        return ans;
    }
}
