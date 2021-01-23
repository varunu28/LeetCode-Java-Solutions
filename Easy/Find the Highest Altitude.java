class Solution {
  public int largestAltitude(int[] gain) {
    int highestAltitude = 0;
    int currAltitude = 0;
    for (int i = 0; i < gain.length; i++) {
      currAltitude += gain[i];
      highestAltitude = Math.max(highestAltitude, currAltitude);
    }
    return highestAltitude;
  }
}
