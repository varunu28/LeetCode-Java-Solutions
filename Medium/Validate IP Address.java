class Solution {
  public String validIPAddress(String IP) {
    if (IP.indexOf(':') != -1) {
      return validateIPv6(IP);
    }
    else if (IP.indexOf('.') != -1) {
      return validateIPv4(IP);
    }
    else {
      return "Neither";
    }
  }
  
  private String validateIPv6(String ip) {
    int count = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ip.length(); i++) {
      if (ip.charAt(i) == ':') {
        if (!isValidIPv6(sb.toString())) {
          return "Neither";
        }
        sb = new StringBuilder();
        count++;
      }
      else {
        sb.append(ip.charAt(i));
      }
      if (i == ip.length() - 1) {
        if (!isValidIPv6(sb.toString())) {
          return "Neither";
        }
      }
    }
    return count == 7 ? "IPv6" : "Neither";
  }
  
  private boolean isValidIPv6(String s) {
    String lower = "abcdef";
    String upper = "ABCDEF";
    if (s.length() == 0 || s.length() > 4) {
      return false;
    }
    for (char c : s.toCharArray()) {
      if (!Character.isDigit(c)) {
        if (lower.indexOf(c) == -1 && upper.indexOf(c) == -1) {
          return false;
        }
      }
    }
    return true;
  }
  
  private String validateIPv4(String ip) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (int i = 0; i < ip.length(); i++) {
      if (ip.charAt(i) == '.') {
        if (!isValidIPv4(sb.toString())) {
          return "Neither";
        }
        sb = new StringBuilder();
        count++;
      }
      else {
        if (!Character.isDigit(ip.charAt(i))) {
          return "Neither";
        }
        sb.append(ip.charAt(i));
      }
      if (i == ip.length() - 1) {
        if (!isValidIPv4(sb.toString())) {
          return "Neither";
        }
      }
    }
    return count == 3 ? "IPv4" : "Neither";
  }
  
  private boolean isValidIPv4(String s) {
    if (s.length() == 0) {
      return false;
    }
    try {
      int val = Integer.parseInt(s);
      if (val < 0 || val > 255) {
        return false;
      }
      if ((s.startsWith("0") && val != 0) || (val == 0 && s.length() > 1)) {
        return false;
      }
    }
    catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
