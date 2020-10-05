class Solution {
  public int bitwiseComplement(int N) {
    if (N == 0) {
      return 1;
    }
    int todo = N;
    int bit = 1;
    while (todo != 0) {
      N = N ^ bit;
      bit = bit << 1;
      todo = todo >> 1;
    }
    return N;
  }
}
