class Solution {
  public int findMinDifference(List<String> timePoints) {
    List<Integer> minutes = new ArrayList<>();
    for (String timePoint : timePoints) {
      minutes.add(
        Integer.parseInt(timePoint.split(":")[0]) * 60 + 
        Integer.parseInt(timePoint.split(":")[1]));
    }
    Collections.sort(minutes);
    int prev = Integer.MIN_VALUE;
    int minDiff = Integer.MAX_VALUE;
    for (int minute : minutes) {
      if (prev != Integer.MIN_VALUE) {
        minDiff = Math.min(minDiff, minute - prev);
      }
      prev = minute;
    }
    minDiff = Math.min(minDiff, (24 * 60 - minutes.get(minutes.size() - 1) + minutes.get(0)));
    return minDiff;
  }
}
