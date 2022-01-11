class Solution {
  public int[] maxDepthAfterSplit(String seq) {
    int[] maxDepth = new int[seq.length()];
    int currDepth = 0;
    for (int i = 0; i < seq.length(); i++) {
      if (seq.charAt(i) == '(') {
        currDepth++;
      }
      System.out.println(i + " " + seq.charAt(i) + " " + currDepth);
      maxDepth[i] = currDepth % 2;
      if (seq.charAt(i) != '(') {
        currDepth--;
      }
    }
    return maxDepth;
  }
}
