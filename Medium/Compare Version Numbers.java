class Solution {
  public int compareVersion(String version1, String version2) {
    String[] splitOne = version1.split("\\.");
    String[] splitTwo = version2.split("\\.");
    int i = 0;
    for (i = 0; i < Math.min(splitOne.length, splitTwo.length); i++) {
      int diff = Integer.parseInt(splitOne[i]) - Integer.parseInt(splitTwo[i]);
      if (diff == 0) {
        continue;
      }
      return diff < 0 ? -1 : 1;
    }
    while (i < splitOne.length) {
      if (Integer.parseInt(splitOne[i++]) > 0) {
        return 1;
      }
    }
    while (i < splitTwo.length) {
      if (Integer.parseInt(splitTwo[i++]) > 0) {
        return -1;
      }
    }
    return 0;
  } 
}
