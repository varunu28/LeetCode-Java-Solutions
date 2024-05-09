class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int turnCount = 0;
        long happinessSum = 0;
        int idx = happiness.length - 1;
        while (k-- > 0) {
            int currentHappiness = Math.max(0, happiness[idx] - turnCount);
            happinessSum += currentHappiness;
            turnCount++;
            idx--;
        }
        return happinessSum;
    }
}
