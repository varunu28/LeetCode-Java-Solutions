import java.util.Map.Entry;


class Twitter {

  private final Map<Integer, Set<Integer>> userFollowing;
  private final Map<Integer, TweetNode> userToTweet;
  private int timestamp;

  public Twitter() {
    this.userFollowing = new HashMap<>();
    this.timestamp = 0;
    this.userToTweet = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    TweetNode tweetNode = new TweetNode(tweetId, this.timestamp++);
    if (this.userToTweet.containsKey(userId)) {
      tweetNode.next = this.userToTweet.get(userId);
    }
    this.userToTweet.put(userId, tweetNode);
  }

  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<TweetNode> priorityQueue =
        new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
    priorityQueue.addAll(
        this.userToTweet.entrySet().stream()
            .filter(
                entry ->
                    entry.getKey() == userId
                        || this.userFollowing
                            .getOrDefault(userId, new HashSet<>())
                            .contains(entry.getKey()))
            .map(Entry::getValue)
            .collect(Collectors.toList()));
    List<Integer> result = new ArrayList<>();
    while (!priorityQueue.isEmpty() && result.size() < 10) {
      TweetNode removed = priorityQueue.remove();
      result.add(removed.tweetId);
      if (removed.next != null) {
        priorityQueue.add(removed.next);
      }
    }
    return result;
  }

  public void follow(int followerId, int followeeId) {
    this.userFollowing.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (this.userFollowing.getOrDefault(followerId, new HashSet<>()).contains(followeeId)) {
      this.userFollowing.get(followerId).remove(followeeId);
    }
  }

  private static class TweetNode {
    int tweetId;
    int timestamp;
    TweetNode next;

    public TweetNode(int tweetId, int timestamp) {
      this.tweetId = tweetId;
      this.timestamp = timestamp;
    }
  }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
