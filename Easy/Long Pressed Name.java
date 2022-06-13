class Solution {
  public boolean isLongPressedName(String name, String typed) {
    int idxName = 0;
    int idxTyped = 0;
    while (idxName < name.length() && idxTyped < typed.length()) {
      if (name.charAt(idxName) != typed.charAt(idxTyped)) {
        return false;
      }
      char c = name.charAt(idxName);
      int nameFreq = 0;
      while (idxName < name.length() && name.charAt(idxName) == c) {
        idxName++;
        nameFreq++;
      }
      c = typed.charAt(idxTyped);
      int typedFreq = 0;
      while (idxTyped < typed.length() && typed.charAt(idxTyped) == c) {
        idxTyped++;
        typedFreq++;
      }
      if (nameFreq > typedFreq) {
        return false;
      }
    }
    return idxName == name.length() && idxTyped == typed.length();
  }
}
