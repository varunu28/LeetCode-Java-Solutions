class Solution {
  public String longestCommonPrefix(String[] strs) {
    int minLength = Integer.MAX_VALUE;
    int minLengthIdx = -1;
    for (int i = 0; i < strs.length; i++) {
      if (strs[i].length() < minLength) {
        minLength = strs[i].length();
        minLengthIdx = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs[minLengthIdx].length(); i++) {
      for (String str : strs) {
        if (str.charAt(i) != strs[minLengthIdx].charAt(i)) {
          return sb.toString();
        }
      }
      sb.append(strs[minLengthIdx].charAt(i));
    }
    return sb.toString();
  }   
}
