class Solution {
  public int mirrorReflection(int p, int q) {
    int extention = q;
    int reflection = p;
    while (extention % 2 == 0 && reflection % 2 == 0) {
      extention /= 2;
      reflection /= 2;
    }
    if (extention % 2 == 0 && reflection % 2 != 0) {
      return 0;
    } else if (extention % 2 != 0 && reflection % 2 == 0) {
      return 2;
    } else {
      return 1;
    }
  }
}
