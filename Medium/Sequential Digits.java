class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    String bucket = "123456789";
    int n = 10;
    List<Integer> list = new ArrayList<>();
    int lowLength = String.valueOf(low).length();
    int highLength = String.valueOf(high).length();
    for (int length = lowLength; length < highLength + 1; length++) {
      for (int start = 0; start < n - length; start++) {
        int num = Integer.parseInt(bucket.substring(start, start + length));
        if (num >= low && num <= high) {
          list.add(num);
        }
      }
    }
    return list;
  }
}
