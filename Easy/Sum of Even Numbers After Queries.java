class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] evenQuerySum = new int[queries.length];
        
        int currEvenSum = 0;
        for (int num : A) {
            currEvenSum += num % 2 == 0 ? num : 0;
        }
        
        for (int i=0; i<queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];
            boolean wasPrevEven = A[idx] % 2 == 0;
            A[idx] = A[idx] + val;
            
            if (A[idx] % 2 == 0) {
                currEvenSum += wasPrevEven ? val : A[idx];
            }
            else {
                currEvenSum -= wasPrevEven ? (A[idx] - val) : 0;
            }
            
            evenQuerySum[i] = currEvenSum;
        }
        
        return evenQuerySum;
    }
}
