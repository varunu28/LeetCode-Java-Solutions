class Solution {
  public int countVowelPermutation(int n) {
    long aCount = 1;
    long eCount = 1;
    long iCount = 1;
    long oCount = 1;
    long uCount = 1;
    final int MOD = 1000000007;
    for (int i = 1; i < n; i++) {
      long aCountNew = (eCount + iCount + uCount) % MOD;
      long eCountNew = (aCount + iCount) % MOD;
      long iCountNew = (eCount + oCount) % MOD;
      long oCountNew = (iCount) % MOD;
      long uCountNew = (iCount + oCount) % MOD;
      aCount = aCountNew;
      eCount = eCountNew;
      iCount = iCountNew;
      oCount = oCountNew;
      uCount = uCountNew;
    }
    long result = (aCount + eCount + iCount + oCount + uCount) % MOD;
    return (int) result;
  }
}
