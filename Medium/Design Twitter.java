class Twitter {

  /** Initialize your data structure here. */
  Map<Integer, User> userMap;

  int tweetTimeStamp;

  public Twitter() {
    userMap = new HashMap<>();
    tweetTimeStamp = 0;
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    createUserIfNotExist(userId);
    userMap.get(userId).addTweet(tweetId, tweetTimeStamp++);
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    createUserIfNotExist(userId);
    List<User> usersFollowed =
        userMap.get(userId).following.stream()
            .map(e -> userMap.get(e))
            .collect(Collectors.toList());
    return userMap.get(userId).getFeed(usersFollowed);
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if (followerId != followeeId) {
      createUserIfNotExist(followerId);
      createUserIfNotExist(followeeId);
      userMap.get(followerId).following.add(followeeId);
    }
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if (followerId != followeeId) {
      createUserIfNotExist(followerId);
      createUserIfNotExist(followeeId);
      userMap.get(followerId).following.remove(followeeId);
    }
  }

  private void createUserIfNotExist(int userId) {
    userMap.computeIfAbsent(userId, k -> new User(userId));
  }
}

class User {
  int id;
  Set<Integer> following;
  PriorityQueue<Tweet> tweets;

  public User(int id) {
    this.id = id;
    following = new HashSet<>();
    tweets = new PriorityQueue<>((t1, t2) -> t2.timestamp - t1.timestamp);
  }

  public void addTweet(int tweetId, int timestamp) {
    tweets.add(new Tweet(tweetId, timestamp));
  }

  public List<Integer> getFeed(List<User> usersFollowed) {
    PriorityQueue<PriorityQueue<Tweet>> allTweets =
        new PriorityQueue<>(
            (t1, t2) -> {
              if (t2.peek() != null) {
                return t2.peek().timestamp - (t1.peek() != null ? t1.peek().timestamp : 0);
              }
              return 0;
            });
    usersFollowed.add(this);
    usersFollowed.stream()
        .filter(user -> !user.tweets.isEmpty())
        .forEach(user -> allTweets.add(new PriorityQueue<>(user.tweets)));
    List<Integer> feed = new ArrayList<>();
    while (feed.size() < 10 && !allTweets.isEmpty()) {
      PriorityQueue<Tweet> removed = allTweets.remove();
      feed.add(removed.poll().id);
      if (!removed.isEmpty()) {
        allTweets.add(removed);
      }
    }
    return feed;
  }
}

class Tweet {
  int id;
  int timestamp;

  public Tweet(int id, int timestamp) {
    this.id = id;
    this.timestamp = timestamp;
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
