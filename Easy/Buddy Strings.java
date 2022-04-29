class Solution {
  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length()) {
      return false;
    }
    if (s.equals(goal)) {
      Set<Character> set = new HashSet<>();
      for (char c : s.toCharArray()) {
        if (set.contains(c)) {
          return true;
        }
        set.add(c);
      }
      return false;
    }
    char[] mismatch = {'-', '-'};
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != goal.charAt(i)) {
        if (mismatch[0] == '|') {
          return false;
        }
        if (mismatch[0] == '-') {
          mismatch[0] = s.charAt(i);
          mismatch[1] = goal.charAt(i);
        } else {
          if (goal.charAt(i) == mismatch[0] && s.charAt(i) == mismatch[1]) {
            mismatch[0] = '|';
            continue;
          }
          return false;
        }
      }
    }
    return mismatch[0] == '|';
  }
}
