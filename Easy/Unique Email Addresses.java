class Solution {
  public int numUniqueEmails(String[] emails) {
    return Arrays.stream(emails).map(Solution::formatEmail).collect(Collectors.toSet()).size();
  }

  private static String formatEmail(String email) {
    String localName = email.split("@")[0];
    return (localName.indexOf('+') != -1
                ? localName.substring(0, localName.indexOf('+'))
                : localName)
            .replaceAll("\\.", "")
        + "@"
        + email.split("@")[1];
  }
}
