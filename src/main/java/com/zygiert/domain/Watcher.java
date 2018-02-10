package com.zygiert.domain;

public class Watcher {
    private long watcherId;
    private String firstName;
    private String lastName;
    private String comment;
    private static long lastWatcherId = 1;

    public Watcher(){}

    public Watcher(long id, String firstName, String lastName, String comment) {
        this.watcherId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.comment = comment;
    }

    public Watcher(long watcherId, String firstName, String lastName) {
        this.watcherId = watcherId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static long getNextWatcherId() {
        return lastWatcherId ++;
    }

    public static void setLastWatcherId(long lastWatcherId) {
        Watcher.lastWatcherId = lastWatcherId;
    }

    public long getWatcherId() {
        return watcherId;
    }

    public void setWatcherId(long watcherId) {
        this.watcherId = watcherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
