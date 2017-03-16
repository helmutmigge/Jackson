package br.hm.example.jackson;

import java.util.Date;

/**
 * Created by helmutmigge on 15/03/2017.
 */
public class Event {
    private String title;


    public Event(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    private Date date;

    public Date getDate() {
        return date;
    }

    public String getTitle() {

        return title;
    }

    @Override
    public String toString() {
        return String.format("[%s] - %s", this.date, this.title);
    }
}
