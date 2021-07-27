package com.exam4.task2.model;

import java.sql.Timestamp;

public class News {
    private Integer id;
    private String heading;
    private String text;
    private Timestamp dateOf;

    public News(Integer id, String heading, String text, Timestamp dateOf) {
        this.id = id;
        this.heading = heading;
        this.text = text;
        this.dateOf = dateOf;
    }

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDateOf() {
        return dateOf;
    }

    public void setDateOf(Timestamp dateOf) {
        this.dateOf = dateOf;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", dateOf=" + dateOf +
                '}';
    }
}
