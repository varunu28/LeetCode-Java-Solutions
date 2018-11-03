class Twitter {

    /** Initialize your data structure here. */
    Map<Integer, User> userMap;
    Map<User, List<User>> followingMap;
    Map<User, List<User>> followerMap;
    int tweetTimeStamp;

    public Twitter() {
        followingMap = new HashMap<>();
        userMap = new HashMap<>();
        followerMap = new HashMap<>();
        tweetTimeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, userId, tweetTimeStamp);
        tweetTimeStamp++;

        createUserIfAbsent(userId);

        userMap.get(userId).topTweets.add(tweet);
        List<User> followers = followerMap.getOrDefault(userMap.get(userId), new ArrayList<>());
        for (User follower : followers) {
            follower.topTweets.add(tweet);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }

        List<Integer> topTweetIds = new ArrayList<>();
        Set<Integer> tweetIdSet = new HashSet<>();
        List<Tweet> topTweets = new ArrayList<>();

        PriorityQueue<Tweet> pq = userMap.get(userId).topTweets;
        int count = 10;

        while (count > 0 && !pq.isEmpty()) {
            Tweet tweet = pq.poll();
            topTweets.add(tweet);

            List<User> usersFollowing = followingMap.get(userMap.get(userId));

            if ((userMap.containsKey(tweet.userId) && usersFollowing.contains(userMap.get(tweet.userId))) ||
                tweet.userId == userId) {
                if (!tweetIdSet.contains(tweet.tweetId)) {
                    topTweetIds.add(tweet.tweetId);
                    tweetIdSet.add(tweet.tweetId);
                    count--;
                }
            }
        }

        pq.addAll(topTweets);

        return topTweetIds;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        createUserIfAbsent(followeeId);
        createUserIfAbsent(followerId);

        if (!followingMap.get(userMap.get(followerId)).contains(userMap.get(followeeId))) {
            followingMap.get(userMap.get(followerId)).add(userMap.get(followeeId));
            userMap.get(followerId).topTweets.addAll(userMap.get(followeeId).topTweets);
        }

        if (!followerMap.getOrDefault(userMap.get(followeeId), new ArrayList<>()).contains(userMap.get(followerId))) {
            followerMap.get(userMap.get(followeeId)).add(userMap.get(followerId));
        }

    }

    private void createUserIfAbsent(int id) {
        if (!userMap.containsKey(id)) {
            User newUser = new User(id);
            userMap.put(id, newUser);
            List<User> followers = new ArrayList<>();
            List<User> following = new ArrayList<>();

            followingMap.put(newUser, following);
            followerMap.put(newUser, followers);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followeeId)) {
            return;
        }

        if (!userMap.containsKey(followerId)) {
            return;
        }

        if (followingMap.get(userMap.get(followerId)).contains(userMap.get(followeeId))) {
            followingMap.get(userMap.get(followerId)).remove(userMap.get(followeeId));
        }
    }
}

class User {
    public int id;
    public List<Integer> followers;
    PriorityQueue<Tweet> topTweets;

    public User(int id) {
        this.id = id;
        this.followers = new ArrayList<>();
        this.topTweets = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.timestamp - o1.timestamp;
            }
        });
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}

class Tweet {
    public int tweetId;
    public int userId;
    public int timestamp;

    public Tweet(int tweetId, int userId, int timestamp) {
        this.tweetId = tweetId;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", userId=" + userId +
                '}';
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
