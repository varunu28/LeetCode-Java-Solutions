class Solution {
  public int minimumRecolors(String blocks, int k) {
    int minRecolors = Integer.MAX_VALUE;
    int blackBlockCount = 0;
    for (int i = 0; i < k; i++) {
      blackBlockCount += blocks.charAt(i) == 'W' ? 0 : 1;
    }
    int startIdx = 0;
    for (int i = k; i < blocks.length(); i++) {
      minRecolors = Math.min(minRecolors, k - blackBlockCount);
      blackBlockCount += blocks.charAt(startIdx++) == 'W' ? 0 : -1;
      blackBlockCount += blocks.charAt(i) == 'W' ? 0 : 1;
    }
    minRecolors = Math.min(minRecolors, k - blackBlockCount);
    return minRecolors;
  }
}
