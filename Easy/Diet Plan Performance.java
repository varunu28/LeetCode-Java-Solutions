class Solution {
    int points;
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        points = 0;
        int totalCal = 0;
        int start = 0;
        for (int i = 0; i < k; i++) {
            totalCal += calories[i];
        }
        for (int i = k; i < calories.length; i++) {    
            updatePoints(totalCal, lower, upper);
            totalCal -= calories[start++];
            totalCal += calories[i];
        }
        updatePoints(totalCal, lower, upper);
        return points;
    }
    
    private void updatePoints(int currCal, int lower, int upper) {
        if (currCal < lower) {
            points--;
        }
        if (currCal > upper) {
            points++;
        }
    }
}
