package com.spika.punkpanda.chat.models;

/**
 * Created by ling on 21.07.15..
 */
public class SeenByModel {

    public long at;
    public User user;

    @Override
    public String toString() {
        return "SeenByModel{" +
                "at=" + at +
                ", user=" + user +
                '}';
    }
}
