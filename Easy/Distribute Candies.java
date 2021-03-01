class Solution {
  public int distributeCandies(int[] candyType) {
    return Math.min(
      Arrays.stream(candyType).boxed().collect(Collectors.toSet()).size(),
      candyType.length / 2
    );
  }
}
