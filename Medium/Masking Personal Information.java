class Solution {
  public String maskPII(String s) {
    return s.indexOf('@') != -1 ? maskEmail(s) : maskPhoneNumber(s);
  }

  private String maskPhoneNumber(String phoneNumber) {
    StringBuilder digits = new StringBuilder();
    for (char c : phoneNumber.toCharArray()) {
      if (Character.isDigit(c)) {
        digits.append(c);
      }
    }
    return getMaskedAreaCode(digits.length()) + "***-***-" + digits.substring(digits.length() - 4);
  }

  private String getMaskedAreaCode(int phoneNumberLength) {
    return switch (phoneNumberLength) {
      case 10 -> "";
      case 11 -> "+*-";
      case 12 -> "+**-";
      case 13 -> "+***-";
      default -> null;
    };
  }

  private String maskEmail(String email) {
    String[] split = email.split("@");
    String name = split[0];
    String domain = split[1].toLowerCase();
    String maskedName = Character.toLowerCase(name.charAt(0)) + String.join("", Collections.nCopies(5, "*"))
        + Character.toLowerCase(name.charAt(name.length() - 1));
    return maskedName + "@" + domain;
  }
}
