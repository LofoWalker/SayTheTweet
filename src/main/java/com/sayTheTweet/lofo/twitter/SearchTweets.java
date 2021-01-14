package com.sayTheTweet.lofo.twitter;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.validation.constraints.NotNull;

public class SearchTweets {

    public static void readTweets(){

        ConfigurationBuilder cb = getConfigurationBuilder();

        FilterQuery filterQuery = new FilterQuery();
        filterQuery.track("Сирия", "syria", "syrie", "syrien", "siria", "سوريا").filterLevel("none");

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        twitterStream.addListener(new StatusListenerImpl()).sample().filter(filterQuery);
    }

    @NotNull
    private static ConfigurationBuilder getConfigurationBuilder() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("REPLACE")
            .setOAuthConsumerSecret("REPLACE")
            .setOAuthAccessToken("REPLACE")
            .setOAuthAccessTokenSecret("REPLACE")
        .setTweetModeExtended(true);
        return cb;
    }

}
