class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int maxCandyCount = 0;
    for (int candy : candies) {
      maxCandyCount = Math.max(maxCandyCount, candy);
    }
    List<Boolean> result = new ArrayList<>();
    for (int candy : candies) {
      result.add((candy + extraCandies) >= maxCandyCount);
    }
    return result;
  }
}
