package com.mimmarcelo.ceep.model;

import java.io.Serializable;

public class Note implements Serializable {
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
