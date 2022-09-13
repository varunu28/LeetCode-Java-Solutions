class Solution {
  public boolean validUtf8(int[] data) {
    int numberOfBytes = 0;
    for (int i = 0; i < data.length; i++) {
      String binaryRep = Integer.toBinaryString(data[i]);
      binaryRep = binaryRep.length() >= 8 ? 
        binaryRep.substring(binaryRep.length() - 8) : 
      "00000000".substring(binaryRep.length() % 8) + binaryRep;
      if (numberOfBytes == 0) {
        for (int j = 0; j < binaryRep.length(); j++) {
          if (binaryRep.charAt(j) == '0') {
            break;
          }
          numberOfBytes++;
        }
        if (numberOfBytes == 0) {
          continue;
        }
        if (numberOfBytes > 4 || numberOfBytes == 1) {
          return false;
        } 
      } else {
        if (!(binaryRep.charAt(0) == '1' && binaryRep.charAt(1) == '0')) {
          return false;
        }
      }
      numberOfBytes--;
    }
    return numberOfBytes == 0;
  }
}
