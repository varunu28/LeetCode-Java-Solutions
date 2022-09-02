class Solution {
  public int numUniqueEmails(String[] emails) {
    return Arrays.stream(emails).map(Solution::getFormattedEmail).collect(Collectors.toSet()).size();
  }

  private static String getFormattedEmail(String email) {
    String[] strs = email.split("@");
    int plusIdx = strs[0].indexOf('+');
    String formattedLocalName = strs[0].substring(0, (plusIdx == -1 ? strs[0].length() : plusIdx))
        .replaceAll("\\.", "");
    return formattedLocalName + "@" + strs[1];
  }
}
