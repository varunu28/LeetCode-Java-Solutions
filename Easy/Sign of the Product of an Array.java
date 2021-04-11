class Solution {
  public int arraySign(int[] nums) {
    return Arrays.stream(nums).filter(num -> num == 0).map(e -> 0).findAny()
        .orElse(Arrays.stream(nums).filter(num -> num < 0).count() % 2 == 0 ? 1 : -1);
  }
}
