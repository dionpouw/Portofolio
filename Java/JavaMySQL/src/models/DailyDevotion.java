package models;

public class DailyDevotion {
    private int id;
    private final String title;
    private final String content;

    public DailyDevotion(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}