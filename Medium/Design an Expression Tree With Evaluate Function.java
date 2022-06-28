/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
  public abstract int evaluate();
  // define your fields here
};

class NumericNode extends Node {
  
  private int val;
  
  public NumericNode(int val) {
    this.val = val;  
  }
  
  public int evaluate() {
    return this.val;
  }
}

class OperatorNode extends Node {
  private char operator;
  private Node leftNode;
  private Node rightNode;
  
  public OperatorNode(char operator, Node leftNode, Node rightNode) {
    this.operator = operator;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }
  
  public int evaluate() {
    int leftValue = this.leftNode == null ? 0 : this.leftNode.evaluate();
    int rightValue = this.rightNode == null ? 0 : this.rightNode.evaluate();
    if (this.operator == '+') {
      return leftValue + rightValue;
    } else if (this.operator == '-') {
      return leftValue - rightValue;
    } else if (this.operator == '*') {
      return leftValue * rightValue;
    } else {
      return leftValue / rightValue;
    }
  }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
  Node buildTree(String[] postfix) {
    Stack<Node> stack = new Stack<>();
    for(String token: postfix){
      if (token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")) {
        Node o2 = stack.pop();
        Node o1 = stack.pop();
        stack.push(new OperatorNode(token.charAt(0), o1, o2));
      } else{
        stack.push(new NumericNode(Integer.parseInt(token)));
      }
    }
    return stack.pop();
  }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
