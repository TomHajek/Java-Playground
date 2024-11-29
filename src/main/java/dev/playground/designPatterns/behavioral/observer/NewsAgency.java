package dev.playground.designPatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Publisher class (Observable)
 */
public class NewsAgency {

    // This attribute has to be published to the different channels
    private String news;

    // List of subscribers (observers)
    private List<Channel> channels = new ArrayList<>();

    // Methods to add or remove subscribers (observers)
    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        this.channels.remove(channel);
    }

    /*
     * When there is the state change (new news), we need to notify all the subscribers.
     * We are doing that by using a setter method.
     */
    public void setNews(String news) {
        this.news = news;                           // set the news
        for (Channel channel : this.channels) {     // go through all channels (subscribers) available and call update
            channel.update(this.news);              // method, which will update the news in each channel (subscriber)
        }
    }
}
