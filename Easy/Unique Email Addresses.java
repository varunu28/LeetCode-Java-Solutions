class Solution {
  public int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<>();
    for (String email : emails) {
      set.add(formattedEmail(email));
    }
    return set.size();
  }
  
  private String formattedEmail(String s) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int n = s.length();
    boolean plusFound = false;
    while (i < n) {
      char c = s.charAt(i);
      if (c == '@') {
        break;
      }
      if (plusFound) {
        i++;
        continue;
      }
      else if (c == '+') {
        plusFound = true;
      }
      else if (c != '.') {
        sb.append(c);
      }
      i++;
    }
    while (i < n) {
      sb.append(s.charAt(i++));
    }
    return sb.toString();
  }
}
