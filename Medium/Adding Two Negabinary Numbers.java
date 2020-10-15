class Solution {
  public int[] addNegabinary(int[] arr1, int[] arr2) {
    int idxOne = arr1.length - 1;
    int idxTwo = arr2.length - 1;
    int carry = 0;
    Stack<Integer> stack = new Stack<>();
    while (idxOne >= 0 || idxTwo >= 0 || carry != 0) {
      int valOne = idxOne >= 0 ? arr1[idxOne--] : 0;
      int valTwo = idxTwo >= 0 ? arr2[idxTwo--] : 0;
      carry = valOne + valTwo + carry;
      stack.push(carry & 1);
      carry = -(carry >> 1);
    }
    while (!stack.isEmpty() && stack.peek() == 0) {
      stack.pop();
    }
    int[] result = new int[stack.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = stack.pop();
    }
    return result.length == 0 ? new int[]{0} : result;
  }
}
