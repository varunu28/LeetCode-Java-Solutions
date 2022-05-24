class Solution {
  public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
    int points = 0;
    int totalCalories = 0;
    for (int i = 0; i < k - 1; i++) {
      totalCalories += calories[i];
    }
    for (int i = k - 1; i < calories.length; i++) {
      totalCalories += calories[i];
      points += totalCalories < lower ? -1 : 0;
      points += totalCalories > upper ? 1 : 0;
      totalCalories -= calories[i - k + 1];
    }
    return points;
  }
}
