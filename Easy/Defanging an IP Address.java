class Solution {
  public String defangIPaddr(String address) {
    StringBuilder sb = new StringBuilder();
    for (char c : address.toCharArray()) {
      sb.append(c == '.' ? "[.]" : c);
    }
    return sb.toString();
  }
}
