package com.sayTheTweet.lofo.twitter;

import com.sayTheTweet.lofo.polly.Polly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;


import static com.sayTheTweet.lofo.utils.parseText.parseText;

public class StatusListenerImpl  implements StatusListener {

    private static final Logger logger = LogManager.getLogger(StatusListenerImpl.class);

    public StatusListenerImpl() {
    }

    @Override
    public void onStatus(Status status) {
        Polly polly = new Polly();
        try {
            if (status.getRetweetedStatus() != null) {
                logger.info(parseText(status.getRetweetedStatus().getText()));
                polly.readTweet(parseText(status.getRetweetedStatus().getText()));
            } else {
                logger.info(status.getText());
                polly.readTweet(parseText(status.getText()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }
}
