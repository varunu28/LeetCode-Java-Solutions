class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }
        
        if (totalSum % 3 != 0) {
            return false;
        }
        
        int singlePartitionSum = totalSum / 3;
        int idx = 0;
        int len = A.length;
        int currPartitionSum = 0;
        int count = 0;
        
        while (idx < len) {
            currPartitionSum += A[idx];
            if (currPartitionSum == singlePartitionSum) {
                count++;
                currPartitionSum = 0;
            }
            
            idx++;
        }
        
        return count == 3;
    }
}
