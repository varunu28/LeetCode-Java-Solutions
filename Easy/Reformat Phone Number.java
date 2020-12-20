class Solution {
  public String reformatNumber(String number) {
    List<Character> digits = number.chars().mapToObj(c -> (char) c).filter(Character::isDigit)
        .collect(Collectors.toList());
    StringBuilder sb = new StringBuilder();
    int remainingCharacter = digits.size();
    int idx = 0;
    while (remainingCharacter > 4) {
      for (int i = 0; i < 3; i++) {
        sb.append(digits.get(idx++));
      }
      remainingCharacter -= 3;
      sb.append("-");
    }
    if (remainingCharacter > 3) {
      for (int i = 0; i < 4; i++) {
        sb.append(digits.get(idx++));
        if (i == 1) {
          sb.append('-');
        }
      }
    } else {
      for (; idx < digits.size(); idx++) {
        sb.append(digits.get(idx));
      }
    }
    return sb.toString();
  }
}
