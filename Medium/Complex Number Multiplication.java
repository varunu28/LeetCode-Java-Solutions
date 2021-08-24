class Solution {
  public String complexNumberMultiply(String num1, String num2) {
    int realPartOne = Integer.parseInt(num1.split("\\+")[0]);
    int imaginaryPartOne = Integer.parseInt(num1.split("\\+")[1].substring(0, num1.split("\\+")[1].length() - 1));
    int realPartTwo = Integer.parseInt(num2.split("\\+")[0]);
        int imaginaryPartTwo = Integer.parseInt(num2.split("\\+")[1].substring(0, num2.split("\\+")[1].length() - 1));
    return (realPartOne * realPartTwo - imaginaryPartOne * imaginaryPartTwo) + "+" + (realPartOne * imaginaryPartTwo + realPartTwo * imaginaryPartOne) + "i";
  }
}
