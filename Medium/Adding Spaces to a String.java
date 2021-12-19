class Solution {
  public String addSpaces(String s, int[] spaces) {
    StringBuilder sb = new StringBuilder();
    int startIdx = 0;
    for (int spaceIdx : spaces) {
      sb.append(s.substring(startIdx, spaceIdx)).append(" ");
      startIdx = spaceIdx;
    }
    sb.append(s.substring(startIdx));
    return sb.toString();
  }
}
