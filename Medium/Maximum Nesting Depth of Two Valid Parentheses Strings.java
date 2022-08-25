class Solution {
  public int[] maxDepthAfterSplit(String seq) {
    int[] result = new int[seq.length()];
    int idx = 0;
    int depth = 0;
    for (char c : seq.toCharArray()) {
      result[idx++] = c == '(' ? (depth++ % 2) : (--depth % 2);
    }
    return result;
  }
}
