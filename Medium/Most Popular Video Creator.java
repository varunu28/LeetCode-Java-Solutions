class Solution {
  public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
    Map<String, Long> creatorToViewCount = new HashMap<>();
    Map<String, Pair<String, Long>> creatorToIdWithMaxViews = new HashMap<>();
    long totalMaxViews = 0;
    for (int i = 0; i < creators.length; i++) {
      creatorToViewCount.put(creators[i], creatorToViewCount.getOrDefault(creators[i], 0L) + views[i]);
      if (!creatorToIdWithMaxViews.containsKey(creators[i])) {
        creatorToIdWithMaxViews.put(creators[i], new Pair<>(ids[i], (long) views[i]));
      } else {
        Pair<String, Long> currentIdToViewPair = creatorToIdWithMaxViews.get(creators[i]);
        if (views[i] > currentIdToViewPair.getValue() || 
            (views[i] == currentIdToViewPair.getValue() && ids[i].compareTo(currentIdToViewPair.getKey()) < 0)) {
          creatorToIdWithMaxViews.put(creators[i], new Pair<>(ids[i], (long) views[i]));
        }
      }
      totalMaxViews = Math.max(totalMaxViews, creatorToViewCount.get(creators[i]));
    }
    List<List<String>> result = new ArrayList<>();
    for (String key : creatorToViewCount.keySet()) {
      if (creatorToViewCount.get(key) == totalMaxViews) {
        result.add(Arrays.asList(key, creatorToIdWithMaxViews.get(key).getKey()));
      }
    }
    return result;
  }
}
