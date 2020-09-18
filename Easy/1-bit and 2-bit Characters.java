class Solution {
  public boolean isOneBitCharacter(int[] bits) {
    int idx = 0;
    int n = bits.length; 
    while (idx < n) {
      if (bits[idx] == 1) {
        if (idx + 1 == n - 1) {
          return false;
        }
        else {
          idx += 2;
        }
      }
      else {
        idx++;
      }
    }
    return true;
  }
}
