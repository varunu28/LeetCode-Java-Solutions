class Solution {
  public List<Integer> addToArrayForm(int[] num, int k) {
    int carry = 0;
    int idx = num.length - 1;
    List<Integer> result = new ArrayList<>();
    while (idx >= 0 || carry > 0 || k > 0) {
      int temp = k % 10 + carry + (idx >= 0 ? num[idx--] : 0);
      result.add(temp % 10);
      carry = temp / 10;
      k /= 10;
    }
    Collections.reverse(result);
    return result;
  }
}
