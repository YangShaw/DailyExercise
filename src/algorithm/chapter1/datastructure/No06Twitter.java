package algorithm.chapter1.datastructure;

import java.util.*;

/**
 * @author YangShaw
 * @date 2021/3/29 1:17
 */
public class No06Twitter {

    // 直接把tweet类写成链表节点
    class Tweet {
        private int tweetId;
        private int timestamp;
        private Tweet next;

        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    class User {
        private int userId;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            userId = id;
            followed = new HashSet<>();
            head = null;
            // 关注自己，便于后面统一获取tweet列表的操作
            follow(id);
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unFollow(int id) {
            // 不能取关自己
            if (id != userId) {
                followed.remove(id);
            }
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            // 有点意思
            // 反向往链表里面插入，head指向的是最新的tweet（其对应的时间戳值最大）
            tweet.next = head;
            head = tweet;
        }

    }

    private static int timestamp = 0;
    /** Initialize your data structure here. */
    // 用户id和user
    Map<Integer, User> userMap;
    public No06Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).postTweet(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }
        // 获取followed列表中所有的user对应的tweet
        Set<Integer> followed = userMap.get(userId).followed;
        // 合并k个有序链表，借助优先级队列这个数据结构
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        for (Integer id : followed) {
            Tweet tweet = userMap.get(id).head;
            if (tweet != null) {
                queue.add(tweet);
            }
        }
        // 太巧妙了
        int count = 0;
        while (!queue.isEmpty()) {
            Tweet tweet = queue.poll();
            result.add(tweet.tweetId);
            count++;
            if (count == 10) {
                break;
            }
            tweet = tweet.next;
            if (tweet != null) {
                queue.add(tweet);
            }
        }
        // 返回
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        // 别忘了如果被关注人不存在也要新建
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unFollow(followeeId);
        }
    }
}
