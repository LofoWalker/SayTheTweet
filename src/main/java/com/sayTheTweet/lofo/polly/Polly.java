package com.sayTheTweet.lofo.polly;

import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

public class Polly {

    private final AmazonPollyClient polly;
    private final Voice voice;

    public Polly() {
        polly = new AmazonPollyClient(new AmazonPollyClientImpl());
        DescribeVoicesRequest describeVoicesRequest = new DescribeVoicesRequest().withLanguageCode("fr-FR");

        DescribeVoicesResult describeVoicesResult = polly.describeVoices(describeVoicesRequest).withVoices(new Voice());
        voice = describeVoicesResult.getVoices().stream().findFirst().orElse(null);
    }

    public Polly(String langue) {
        polly = new AmazonPollyClient(new AmazonPollyClientImpl());

        DescribeVoicesRequest describeVoicesRequest = new DescribeVoicesRequest().withLanguageCode(langue);

        DescribeVoicesResult describeVoicesResult = polly.describeVoices(describeVoicesRequest).withVoices(new Voice());
        voice = describeVoicesResult.getVoices().stream().findFirst().orElse(null);
    }

    public InputStream synthesize(String text, OutputFormat format) {
        SynthesizeSpeechRequest synthReq =
            new SynthesizeSpeechRequest().withText(text).withVoiceId(voice.getId())
                .withOutputFormat(format);
        SynthesizeSpeechResult synthRes = polly.synthesizeSpeech(synthReq);

        return synthRes.getAudioStream();
    }

    private String getLangue(String message) {
        if (message.contains("Syrie")) {
            return "fr-FR";
        } else if (message.contains("Syria")){
            return "en-US";
        } else if (message.contains("syrien")) {
            return "de-DE";
        } else if (message.contains("siria")) {
            return "es-ES";
        } else if (message.contains("Сирия")) {
            return "ru-RU";
        } else if (message.contains("سوريا")) {
            return "arb";
        }
        return "en-US";
    }

    public void readTweet(String message) {
        //create the test class
        Polly helloWorld = new Polly(getLangue(message));

        //get the audio stream
        InputStream speechStream = helloWorld.synthesize(message, OutputFormat.Mp3);
        //create an MP3 player
        try {
            Player player = new Player(speechStream);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
