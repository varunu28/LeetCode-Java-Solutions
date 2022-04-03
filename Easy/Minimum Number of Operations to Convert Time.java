class Solution {
  public int convertTime(String current, String correct) {
    int minutesDiff = getMinutes(correct) - getMinutes(current);
    int numOfOperations = 0;
    int[] incrementFactors = {60, 15, 5, 1};
    for (int i = 0; i < incrementFactors.length; i++) {
      numOfOperations += minutesDiff / incrementFactors[i];
      minutesDiff %= incrementFactors[i];
    }
    return numOfOperations;
  }

  private int getMinutes(String time) {
    String[] split = time.split(":");
    return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
  }
}
