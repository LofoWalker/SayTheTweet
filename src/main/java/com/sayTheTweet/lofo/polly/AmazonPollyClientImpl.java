package com.sayTheTweet.lofo.polly;

import com.amazonaws.auth.AWSCredentials;

public class AmazonPollyClientImpl implements AWSCredentials {

    private static final String ACCESS_KEY = "REMPLACER PAR VOTRE ACCESS KEY";
    private static final String SECRET_KEY = "REMPLACER PAR VOTRE SECRET KEY";

    @Override
    public String getAWSSecretKey() {
        return SECRET_KEY;
    }

    @Override
    public String getAWSAccessKeyId() {
        return ACCESS_KEY;
    }
}
