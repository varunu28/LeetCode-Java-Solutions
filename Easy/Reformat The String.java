class Solution {
  public String reformat(String s) {
    List<Character> letters = new ArrayList<>();
    List<Character> digits = new ArrayList<>();
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        letters.add(c);
      }
      else {
        digits.add(c);
      }
    }
    if (Math.abs(letters.size() - digits.size()) > 1) {
      return "";
    }
    return letters.size() > digits.size() ? formPermutation(letters, digits) : formPermutation(digits, letters);
  }
  
  private String formPermutation(List<Character> l1, List<Character> l2) {
    StringBuilder sb = new StringBuilder();
    int idx1 = 0;
    int idx2 = 0;
    boolean isL1 = true;
    while (idx1 < l1.size() && idx2 < l2.size()) {
      sb.append(isL1 ? l1.get(idx1++) : l2.get(idx2++));
      isL1 = !isL1;
    }
    if (idx1 < l1.size()) {
      sb.append(l1.get(idx1));
    }
    if (idx2 < l2.size()) {
      sb.append(l2.get(idx2));
    }
    return sb.toString();
  }
}
