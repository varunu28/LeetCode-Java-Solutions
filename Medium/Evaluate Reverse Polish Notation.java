class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    String operations = "+-/*";
    for (String token : tokens) {
      stack.push(operations.contains(token) ? Objects
          .requireNonNull(performOperation(stack.pop(), stack.pop(), token))
          : Integer.parseInt(token));
    }
    return stack.pop();
  }

  private Integer performOperation(Integer secondOperand, Integer firstOperand, String operation) {
    switch (operation) {
      case "+":
        return firstOperand + secondOperand;
      case "-":
        return firstOperand - secondOperand;
      case "*":
        return firstOperand * secondOperand;
      case "/":
        return firstOperand / secondOperand;
      default:
        return null;
    }
  }
}
