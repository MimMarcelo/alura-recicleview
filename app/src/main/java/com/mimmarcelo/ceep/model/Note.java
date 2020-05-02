package com.mimmarcelo.ceep.model;

public class Note {
    private final String header;
    private final String content;

    public Note(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }
}
