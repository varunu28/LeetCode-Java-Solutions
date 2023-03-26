class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        sum += Math.min(numOnes, k) * 1;
        k -= Math.min(numOnes, k);
        sum += Math.min(numZeros, k) * 0;
        k -= Math.min(numZeros, k);
        sum += Math.min(numNegOnes, k) * -1;
        return sum;
    }
}
