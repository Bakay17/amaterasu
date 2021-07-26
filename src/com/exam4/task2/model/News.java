package com.exam4.task2.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class News {
    private Integer id;
    private String heading;
    private String text;
    private Date dateOf;

    public News(Integer id, String heading, String text, Date dateOf) {
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

    public Date getDateOf() {
        return dateOf;
    }

    public void setDateOf(Date dateOf) {
        this.dateOf = dateOf;
    }
}
