class Solution {
  public boolean buddyStrings(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    char requiredChar = '-';
    char mismatchChar = '-';
    int[] counter = new int[26];
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) != B.charAt(i)) {
	      // Already done one swap hence cannot do any more swaps
        if (requiredChar == '_') {
          return false;
        }
        if (requiredChar == '-') {
          requiredChar = B.charAt(i);
          mismatchChar = A.charAt(i);
        }
        else {
		      // Check if swap is possible from previous mismatch
          if (B.charAt(i) == mismatchChar && A.charAt(i) == requiredChar) {
            requiredChar = '_';
          }
          else {
            return false;
          }
        }
      }
      else {
        counter[A.charAt(i) - 'a']++;
      }
    }
    if (mismatchChar != '-') {
      return requiredChar == '_';
    }
    // Check if we have more than 1 occurrence of same characters. We can swap them to fulfil the condition
    for (int i = 0; i < 26; i++) {
      if (counter[i] > 1) {
        return true;
      }
    }
    return false;
  }
}
