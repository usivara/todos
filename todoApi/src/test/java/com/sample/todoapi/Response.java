package com.sample.todoapi;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Response {
    @JsonProperty("_embedded")
    private Embedded embedded;

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }
}
