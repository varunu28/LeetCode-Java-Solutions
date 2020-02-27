class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    String closing = ")}]";
    String opening = "({[";
    
    for (char c : s.toCharArray()) {
      if (closing.indexOf(c) == -1) {
        stack.push(c);
      }
      else {
        if (stack.isEmpty()) {
          System.out.println("HERE");
          return false;
        }
        char temp = stack.pop();
        if (opening.indexOf(temp) != closing.indexOf(c)) {
          System.out.println(opening.indexOf(temp) + " " + closing.indexOf(c));
          return false;
        }
      }
    }
    System.out.println(stack);
    return stack.isEmpty();
  }
}
