class Solution {
  public int compareVersion(String version1, String version2) {
    String[] versionOneSplit = version1.split("\\.");
    String[] versionTwoSplit = version2.split("\\.");
    int idxOne = 0;
    int idxTwo = 0;
    while (idxOne < versionOneSplit.length && idxTwo < versionTwoSplit.length) {
      int diff = Integer.parseInt(versionOneSplit[idxOne]) - Integer.parseInt(versionTwoSplit[idxTwo]);
      if (diff < 0) {
        return -1;
      } else if (diff > 0) {
        return 1;
      }
      idxOne++;
      idxTwo++;
    }
    if (containsNonZeroRevision(versionOneSplit, idxOne)) {
      return 1;
    } else if (containsNonZeroRevision(versionTwoSplit, idxTwo)) {
      return -1;
    }
    return 0;
  }
  
  private boolean containsNonZeroRevision(String[] versions, int idx) {
    for (int i = idx; i < versions.length; i++) {
      if (Integer.parseInt(versions[i]) > 0) {
        return true;
      }
    }
    return false;
  }
}
