class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        final int maxCandy = Arrays.stream(candies)
            .max()
            .orElse(0);
        return Arrays.stream(candies)
            .mapToObj(candy -> candy + extraCandies >= maxCandy)
            .collect(Collectors.toList());
    }
}
