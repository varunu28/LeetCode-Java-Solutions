class Solution {
  public String nextClosestTime(String time) {
    int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    Set<Integer> digits = new HashSet<>();
    for (char c : time.toCharArray()) {
      digits.add(c - '0');
    }
    while (true) {
      minutes = (minutes + 1) % (24 * 60);
      int[] nextTime = {minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10};
      boolean found = true;
      for (int unit : nextTime) {
        if (!digits.contains(unit)) {
          found = false;
          break;
        }
      }
      if (found) {
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
      }
    }
  }
}
