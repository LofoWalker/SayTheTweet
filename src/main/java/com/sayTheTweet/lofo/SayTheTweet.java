package com.sayTheTweet.lofo;

import com.sayTheTweet.lofo.twitter.SearchTweets;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SayTheTweet {

	public static void main(String[] args) {
	    SpringApplication.run(SayTheTweet.class, args);
        SearchTweets.readTweets();
    }

}
