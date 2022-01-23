class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    String bucket = "123456789";
    int n = 10;
    List<Integer> result = new ArrayList<>();
    int minLength = String.valueOf(low).length();
    int maxLength = String.valueOf(high).length();
    for (int currLength = minLength; currLength <= maxLength; currLength++) {
      for (int idx = 0; idx < n - currLength; idx++) {
        int num = Integer.parseInt(bucket.substring(idx, idx + currLength));
        if (num >= low && num <= high) {
          result.add(num);
        }
      }
    }
    return result;
  }
}
