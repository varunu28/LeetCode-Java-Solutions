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
    
    @Override
    public int evaluate() {
        return this.val;
    }
}


class OperatorNode extends Node {
    private char operator;
    private Node left;
    private Node right;
    
    public OperatorNode(char operator) {
        this.operator = operator;
        this.left = null;
        this.right = null;
    }
    
    @Override
    public int evaluate() {
        return switch(operator) {
            case '+' -> left.evaluate() + right.evaluate();
            case '-' -> left.evaluate() - right.evaluate();
            case '*' -> left.evaluate() * right.evaluate();
            case '/' -> left.evaluate() / right.evaluate();
            default -> 0;
        };
    }
    
    public void setRightNode(Node right) {
        this.right = right;
    }
    
    public void setLeftNode(Node left) {
        this.left = left;
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    private static final Set<String> OPERATORS = Set.of("+", "-", "/", "*");
    
    Node buildTree(String[] postfix) {
        int[] idx = {postfix.length - 1};
        return buildTree(postfix, idx);
    }
    
    private Node buildTree(String[] postfix, int[] idx) {
        if (idx[0] < 0) {
            return null;
        }
        String val = postfix[idx[0]--];
        if (OPERATORS.contains(val)) {
            OperatorNode node = new OperatorNode(val.charAt(0));
            node.setRightNode(buildTree(postfix, idx));
            node.setLeftNode(buildTree(postfix, idx));
            return node;
        }
        NumericNode node = new NumericNode(Integer.parseInt(val));
        return node;
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
