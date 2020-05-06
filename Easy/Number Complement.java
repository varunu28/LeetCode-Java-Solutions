class Solution {
  public int findComplement(int num) {
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      int rem = num % 2;
      num /= 2;
      sb.append(rem);
    }
    StringBuilder complement = new StringBuilder();
    for (int i = 0; i < sb.length(); i++) {
      complement.append(sb.charAt(i) == '1' ? '0' : '1');
    }
    int newNum = 0;
    int pow = 0;
    for (int i = 0; i < complement.length(); i++) {
      newNum += ((int) Math.pow(2, pow)) * Character.getNumericValue(complement.charAt(i));
      pow++;
    }
    return newNum;
  }
}
