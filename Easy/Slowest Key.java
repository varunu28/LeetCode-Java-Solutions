class Solution {
  public char slowestKey(int[] releaseTimes, String keysPressed) {
    int startTime = 0;
    int maxPressedTime = 0;
    char keyWithLongestTime = keysPressed.charAt(0);
    for (int i = 0; i < releaseTimes.length; i++) {
      int totalTime = releaseTimes[i] - startTime;
      if (maxPressedTime < totalTime) {
        keyWithLongestTime = keysPressed.charAt(i);
        maxPressedTime = totalTime;
      } else if (maxPressedTime == totalTime && keyWithLongestTime < keysPressed.charAt(i)) {
        keyWithLongestTime = keysPressed.charAt(i);
      }
      startTime = releaseTimes[i];
    }
    return keyWithLongestTime;
  }
}
