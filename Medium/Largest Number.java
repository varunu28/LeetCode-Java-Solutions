class Solution {
  public String largestNumber(int[] nums) {
    String largestNum = Arrays.stream(nums)
        .boxed()
        .map(String::valueOf)
        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
        .collect(Collectors.joining(""));
    return largestNum.charAt(0) == '0' ? "0" : largestNum;
  }
}
