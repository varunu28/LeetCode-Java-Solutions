class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int max = Integer.MIN_VALUE;
    for (int candy : candies) {
      max = Math.max(max, candy);
    }
    List<Boolean> ans = new ArrayList<>();
    for (int i = 0; i < candies.length; i++) {
      ans.add((candies[i] + extraCandies) >= max);
    }
    return ans;
  }
}
