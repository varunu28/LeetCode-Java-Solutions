class Solution {
  public char slowestKey(int[] releaseTimes, String keysPressed) {
    int maxReleaseTime = 0;
    int maxReleaseTimeIdx = 0;
    for (int i = 0; i < releaseTimes.length; i++) {
      int idx = keysPressed.charAt(i) - 'a';
      int currReleaseTime = i == 0 ? releaseTimes[i] : (releaseTimes[i] - releaseTimes[i - 1]);
      if (currReleaseTime > maxReleaseTime) {
        maxReleaseTimeIdx = idx;
        maxReleaseTime = currReleaseTime;
      } else if (maxReleaseTime == currReleaseTime && maxReleaseTimeIdx < idx) {
        maxReleaseTimeIdx = idx;
      }
    }
    return ((char) ('a' + maxReleaseTimeIdx));
  }   
}
