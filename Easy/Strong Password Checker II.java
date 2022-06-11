class Solution {
  public boolean strongPasswordCheckerII(String password) {
    boolean lowerCaseFound = false;
    boolean upperCaseFound = false;
    boolean digitFound = false;
    boolean specialCharFound = false;
    String specialChars = "!@#$%^&*()-+";
    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      if (specialChars.indexOf(c) != -1) {
        specialCharFound = true;
      } else if (Character.isDigit(c)) {
        digitFound = true;
      } else if (Character.isUpperCase(c)) {
        upperCaseFound = true;
      } else if (Character.isLowerCase(c)) {
        lowerCaseFound = true;
      }
      if (i > 0 && password.charAt(i - 1) == c) {
        return false;
      }
    }
    return password.length() >= 8 && lowerCaseFound && upperCaseFound && digitFound && specialCharFound;
  }
}
