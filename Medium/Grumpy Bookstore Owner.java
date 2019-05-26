class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int totalSum = 0;
        int maxDiff = 0;
        int grumpySum = 0;
        
        for (int i = 0; i < customers.length; i++) {
            totalSum += grumpy[i] == 1 ? 0 : customers[i];
            grumpySum += grumpy[i] == 1 ? customers[i] : 0;
            if (i >= X) {
                grumpySum -= grumpy[i - X] == 1 ? customers[i - X] : 0;
            }
            
            maxDiff = Math.max(maxDiff, grumpySum);
        }

        return totalSum + maxDiff;
    }
}
