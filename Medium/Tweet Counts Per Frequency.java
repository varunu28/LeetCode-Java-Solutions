class TweetCounts {

  private final Map<String, TreeMap<Integer, Integer>> map;
  private static final Map<String, Integer> INTERVAL_MAP = Map.of(
      "minute", 60,
      "hour", 3600,
      "day", 86400);

  public TweetCounts() {
    this.map = new HashMap<>();
  }

  public void recordTweet(String tweetName, int time) {
    map.computeIfAbsent(tweetName, k -> new TreeMap<>());
    map.get(tweetName).merge(time, 1, Integer::sum);
  }

  public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
    int interval = INTERVAL_MAP.get(freq);
    int size = ((endTime - startTime) / interval + 1);
    int[] buckets = new int[size];
    TreeMap<Integer, Integer> frequencyMap = map.get(tweetName);
    for (Integer key : frequencyMap.subMap(startTime, endTime + 1).keySet()) {
      int idx = (key - startTime) / interval;
      buckets[idx] += frequencyMap.get(key);
    }
    return Arrays.stream(buckets).boxed().collect(Collectors.toList());
  }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
