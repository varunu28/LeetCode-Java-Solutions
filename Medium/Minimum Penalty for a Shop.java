class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int minPenalty = 0;
        int currPenalty = 0;
        int minPenaltyHour = 0;
        for (int i = 0; i < n; i++) {
            currPenalty += customers.charAt(i) == 'Y' ? -1 : 1;
            if (currPenalty < minPenalty) {
                minPenaltyHour = i + 1;
                minPenalty = currPenalty;
            }
        }
        return minPenaltyHour;
    }
}
