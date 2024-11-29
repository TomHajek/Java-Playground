package dev.playground.designPatterns.behavioral.observer;

/**
 * This is a concrete implementation of a subscriber (observer)
 */
public class NewsChannel implements Channel {

    // It has a news object as an attribute
    private String news;

    /*
     * Implementing observer method.
     * It is setting a value to news attribute, whatever news data has been passed.
     * We will assign this value to our local variable.
     */
    @Override
    public void update(Object news) {
        this.setNews((String) news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

}