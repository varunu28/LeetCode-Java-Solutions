class Solution {
  public int finalValueAfterOperations(String[] operations) {
    int x = 0;
    for (String op : operations) {
      x += op.indexOf('-') != -1 ? -1 : 1;
    }
    return x;
  }
}
