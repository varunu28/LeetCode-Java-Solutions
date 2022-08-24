class Solution {
  public String sortSentence(String s) {
    String[] positions = new String[9];
    String[] strs = s.split("\\s+");
    for (String str : strs) {
      int digit = Character.getNumericValue(str.charAt(str.length() - 1));
      positions[digit - 1] = str.substring(0, str.length() - 1);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < positions.length; i++) {
      if (positions[i] == null) {
        break;
      }
      sb.append(positions[i]).append(" ");
    }
    return sb.toString().trim();
  }
}
