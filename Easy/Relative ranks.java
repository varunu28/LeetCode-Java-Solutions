class Solution {
  public String[] findRelativeRanks(int[] nums) {
    PriorityQueue<Integer> orderedRanking = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);
    orderedRanking.addAll(IntStream.range(0, nums.length).boxed().collect(Collectors.toList()));
    String[] relativeRanks = new String[nums.length];
    int currentRank = 1;
    while (!orderedRanking.isEmpty()) {
      int removed = orderedRanking.poll();
      if (currentRank > 3) {
        relativeRanks[removed] = String.valueOf(currentRank++);
      } else {
        relativeRanks[removed] = (
            currentRank == 1 ? "Gold Medal" : (currentRank == 2 ? "Silver Medal" : "Bronze Medal")
        );
        currentRank++;
      }
    }
    return relativeRanks;
  }
}
