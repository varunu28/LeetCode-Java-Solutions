class Solution {
  public boolean isLongPressedName(String name, String typed) {
    int nameIdx = 0;
    int typeIdx = 0;
    int nameLen = name.length();
    int typeLen = typed.length();
    while (nameIdx < nameLen && typeIdx < typeLen) {
      if (name.charAt(nameIdx) != typed.charAt(typeIdx)) {
        return false;
      }
      while (nameIdx < nameLen && typeIdx < typeLen && name.charAt(nameIdx) == typed.charAt(typeIdx)) {
        nameIdx++;
        typeIdx++;
      }
      char prev = name.charAt(nameIdx - 1);
      while (typeIdx < typeLen && typed.charAt(typeIdx) == prev) {
        typeIdx++;
      }
    }
    return nameIdx == nameLen && typeIdx == typeLen;
  }
}
