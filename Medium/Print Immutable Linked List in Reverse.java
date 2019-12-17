/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
  Stack<ImmutableListNode> stack;
  ImmutableListNode lastPopped;
  public void printLinkedListInReverse(ImmutableListNode head) {
    stack = new Stack<>();
    lastPopped = null;
    int lengthSquareRoot = (int) Math.log(getLength(head));
    ImmutableListNode curr = head;
    int count = 0;
    while (curr != null) {
      if (count % lengthSquareRoot == 0) {
        stack.push(curr);
      }
      curr = curr.getNext();
      count++;
    }
    while (!stack.isEmpty()) {
      ImmutableListNode popped = stack.pop();
      printNode(popped);
      lastPopped = popped;
    }
  }
  
  private void printNode(ImmutableListNode node) {
    if (node == lastPopped) {
      return;
    }
    printNode(node.getNext());
    node.printValue();
  }
  
  private int getLength(ImmutableListNode node) {
    int count = 0;
    while (node != null) {
      node = node.getNext();
      count++;
    }
    return count;
  }
}

