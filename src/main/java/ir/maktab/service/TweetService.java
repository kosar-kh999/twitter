package ir.maktab.service;

import ir.maktab.model.Tweet;
import ir.maktab.repository.TweetRepository;

import java.util.List;

public class TweetService {
    TweetRepository tweetRepository = new TweetRepository();

    public void writeNewTweet(Tweet tweet) {
        tweetRepository.creat(tweet);
    }

    public Tweet findByUsername(String username) {
        return tweetRepository.findByUsername(username);
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.getAll();
    }

    public void updateTweets(Tweet tweet) {
        tweetRepository.update(tweet);
    }

    public void removeTweet(Tweet tweet) {
        tweetRepository.remove(tweet);
    }
}
