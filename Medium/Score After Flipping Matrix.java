class Solution {
    public int matrixScore(int[][] A) {
        for (int i=0; i<A.length; i++) {
            int actualSum = getDecimalValue(A[i], false);
            int toggledSum = getDecimalValue(A[i], true);
            
            if (toggledSum > actualSum) {
                for (int j=0; j<A[i].length; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        
        for (int i=0; i<A[0].length; i++) {
            int numZeroes = 0;
            int numOnes = 0;
            
            for (int j=0; j<A.length; j++) {
                if (A[j][i] == 1 ) {
                    numOnes++;
                }
                else {
                    numZeroes++;
                }
            }
            
            if (numZeroes > numOnes) {
                for (int j=0; j<A.length; j++) {
                    A[j][i] ^= 1;
                }
            }
        }
        
        int maxSum = 0;
        for (int[] arr : A) {
            maxSum += getDecimalValue(arr, false);
        }
        
        return maxSum;
    }
    
    private int getDecimalValue(int[] arr, boolean isToggled) {
        int sum = 0;
        int pow = 0;
        
        for (int i=arr.length-1; i>=0; i--) {
            if (isToggled) {
                sum += Math.pow(2, pow) * (arr[i] ^ 1);
            }
            else {
                sum += Math.pow(2, pow) * arr[i];
            }
            
            pow++;
        }
        
        return sum;
    }
}
