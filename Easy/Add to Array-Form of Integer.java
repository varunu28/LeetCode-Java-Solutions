class Solution {
  public List<Integer> addToArrayForm(int[] A, int K) {
    List<Integer> list = new ArrayList<>();
    int idx = A.length - 1;
    int carry = 0;
    while (K > 0 || idx >= 0 || carry > 0) {
      int temp = (
        (K > 0 ? K % 10 : 0) +
        (idx >= 0 ? A[idx--] : 0) + 
        carry
      );
      K /= 10;
      carry = temp > 9 ? temp / 10 : 0;
      temp = temp > 9 ? temp % 10 : temp;
      list.add(temp);
    }
    Collections.reverse(list);
    return list;
  }
}
