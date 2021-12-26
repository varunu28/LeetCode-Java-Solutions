class Solution {
  public boolean isSameAfterReversals(int num) {
    return parseToInteger(reverseNum(parseToInteger(reverseNum(num)))) == num;
  }
  
  private String reverseNum(int num) {
    return new StringBuilder().append(num).reverse().toString();
  }
  
  private Integer parseToInteger(String s) {
    return Integer.parseInt(s);
  }
}
