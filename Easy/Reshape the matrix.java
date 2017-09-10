class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int numOfElem = nums.length*nums[0].length;
        if (numOfElem != r*c) {
            return nums;
        }
        
        int[] expandedArray = new int[numOfElem];
        int k = 0;
        
        for (int i=0;i<nums.length;i++) {
            for (int j=0;j<nums[i].length;j++) {
                expandedArray[k] = nums[i][j];
                k++;
            }
        }
        
        int[][] ans = new int[r][c];
        int i=0;
        int j=0;
        for(k=0;k<numOfElem;k++) {
            ans[i][j] = expandedArray[k];
            j++;
            if (j == c) {
                j = 0;
                i++;
            }
        }
        return ans;
    }
}
