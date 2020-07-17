class Solution {
  public String toGoatLatin(String S) {
    StringBuilder sb = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    String vowels = "aeiouAEIOU";
    StringBuilder aAppend = new StringBuilder("a");
    int idx = 0;
    int n = S.length();
    Boolean startVowel = null;
    while (idx < n) {
      if (startVowel == null) {
        startVowel = vowels.indexOf(S.charAt(idx)) != -1;
      }
      if (S.charAt(idx) == ' ' || idx == n - 1) {
        if (S.charAt(idx) != ' ') {
          temp.append(S.charAt(idx));
        }
        if (!startVowel) {
          char c = temp.charAt(0);
          temp.deleteCharAt(0);
          temp.append(c);
        }
        temp.append("ma").append(aAppend.toString());
        sb.append(temp.toString());
        temp.setLength(0);
        aAppend.append("a");
        startVowel = null;
        if (idx != n - 1) {
          sb.append(" ");
        }
      }
      else {
        temp.append(S.charAt(idx));
      }
      idx++;
    }
    return sb.toString();
  }
}
