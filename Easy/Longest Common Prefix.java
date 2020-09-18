class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    int minLength = Integer.MAX_VALUE;
    int idx = -1;
    for (int i = 0; i < strs.length; i++) {
      if (strs[i].length() < minLength) {
        minLength = strs[i].length();
        idx = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs[idx].length(); i++) {
      boolean flag = true;
      for (String str : strs) {
        if (str.charAt(i) != strs[idx].charAt(i)) {
          flag = false;
          break;
        }
      }
      if (!flag) {
        break;
      }
      sb.append(strs[idx].charAt(i));
    }
    return sb.toString();
  }
}
