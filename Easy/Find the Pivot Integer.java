class Solution {
    public int pivotInteger(int n) {
        int[] leftToRightSum = new int[n];
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += i + 1;
            leftToRightSum[i] = currSum;
        }
        int rightToLeftSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightToLeftSum += i + 1;
            if (leftToRightSum[i] == rightToLeftSum) {
                return i + 1;
            }
        }
        return -1;
    }
}
