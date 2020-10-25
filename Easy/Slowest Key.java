class Solution {
  public char slowestKey(int[] releaseTimes, String keysPressed) {
    int maxReleaseTime = 0;
    int maxReleaseTimeIdx = 0;
    for (int idx = 0; idx < releaseTimes.length; idx++) {
      int currentIdx = keysPressed.charAt(idx) - 'a';
      int currReleaseTime = releaseTimes[idx] - (idx == 0 ? 0 : releaseTimes[idx - 1]);
      if (currReleaseTime >= maxReleaseTime) {
        if (currReleaseTime > maxReleaseTime)  {
          maxReleaseTimeIdx = currentIdx;
        } else if (currentIdx > maxReleaseTimeIdx) {
          maxReleaseTimeIdx = currentIdx;
        }
        maxReleaseTime = currReleaseTime;
      }
    }
    return (char) (97 + maxReleaseTimeIdx);
  }
}
