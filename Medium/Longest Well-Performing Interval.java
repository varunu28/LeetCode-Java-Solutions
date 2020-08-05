class Solution {
  public int longestWPI(int[] hours) {
    int sum = 0;
    int maxInterval = 0;
    boolean greaterThanEightFound = false;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < hours.length; i++) {
      sum += hours[i] > 8 ? 1 : -1;
      greaterThanEightFound = hours[i] > 8 ? true : greaterThanEightFound;
      map.putIfAbsent(sum, i);
      if (sum >= 1) {
        maxInterval = Math.max(maxInterval, i + 1);
      }
      else if (map.containsKey(sum - 1)) {
        maxInterval = Math.max(maxInterval, i - map.get(sum - 1));
      }
    }
    return maxInterval == 0 ? (greaterThanEightFound ? 1 : 0) : maxInterval;
  }
}
