class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        int[] rightSum = new int[n];
        int runningSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            runningSum += (s.charAt(i) - 'a') + 1;
            rightSum[i] = runningSum;
        }
        runningSum = 0;
        for (int i = 0; i < n - 1; i++) {
            runningSum += (s.charAt(i) - 'a') + 1;
            if (runningSum == rightSum[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
