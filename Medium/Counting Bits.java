class Solution {
  public int[] countBits(int n) {
    int[] numofOnes = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      numofOnes[i] = numofOnes[i / 2] + i % 2;
    }
    return numofOnes;
  }
}
