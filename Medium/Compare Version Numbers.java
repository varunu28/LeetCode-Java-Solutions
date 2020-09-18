class Solution {
  public int compareVersion(String version1, String version2) {
    String[] versionSplit1 = version1.split("\\.");
    String[] versionSplit2 = version2.split("\\.");
    int idx1 = 0;
    int idx2 = 0;
    while (idx1 < versionSplit1.length || idx2 < versionSplit2.length) {
      if (idx1 < versionSplit1.length && idx2 < versionSplit2.length) {
        int ver1 = Integer.parseInt(versionSplit1[idx1++]);
        int ver2 = Integer.parseInt(versionSplit2[idx2++]);
        int c = ver1 - ver2;
        if (c != 0) {
          return c > 0 ? 1 : -1;
        }
      }
      else if (idx1 < versionSplit1.length || idx2 == versionSplit2.length) {
        int ver1 = Integer.parseInt(versionSplit1[idx1++]);
        if (ver1 != 0) {
          return 1;
        }
      }
      else {
        int ver2 = Integer.parseInt(versionSplit2[idx2++]);
        if (ver2 != 0) {
          return -1;
        }
      }
    }
    return 0;
  } 
}
