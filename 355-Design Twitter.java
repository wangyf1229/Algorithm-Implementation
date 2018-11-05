class Twitter {
    public class User {
        public int userId;
        public Set<Integer> followees;
        public Tweet tweets;
        public User(int userId) {
            this.userId = userId;
            followees = new HashSet<>();
            followees.add(userId);
        }
    }
    
    public class Tweet {
        public int tweetId;
        public long timestamp;
        Tweet next;
        public Tweet(int tweetId, long now) {
            this.tweetId = tweetId;
            timestamp = now;
        }
    }
    
    Map<Integer, User> userMap;
    long now;
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
        now = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        Tweet newTweet = new Tweet(tweetId, now);
        now++;
        Tweet firstTweetOfUser = userMap.get(userId).tweets;
        newTweet.next = firstTweetOfUser;
        userMap.get(userId).tweets = newTweet;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) return new ArrayList<Integer>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a , b) -> (Long.compare(b.timestamp, a.timestamp)));
        User user = userMap.get(userId);
        for (int followee : user.followees) {
            if (userMap.containsKey(followee)) {
                User temp = userMap.get(followee);
                if (temp.tweets != null) pq.offer(temp.tweets);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Tweet t = pq.poll();
            if (t.next != null) pq.offer(t.next);
            res.add(t.tweetId);
            if (res.size() == 10) return res;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        userMap.get(followerId).followees.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!userMap.containsKey(followerId)) return;
        userMap.get(followerId).followees.remove(followeeId);
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