class Solution {
  public List<Integer> maxScoreIndices(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = nums[i] + prefix[i];
    }
    int maxScore = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n + 1; i++) {
      int onesToRight = prefix[n] - prefix[i];
      int zerosToLeft = i - prefix[i];
      int currScore = zerosToLeft + onesToRight;
      maxScore = Math.max(maxScore, currScore);
      map.put(i, currScore);
    }
    List<Integer> result = new ArrayList<>();
    for (Integer key : map.keySet()) {
      if (map.get(key).equals(maxScore)) {
        result.add(key);
      }
    }
    return result;
  }
}
