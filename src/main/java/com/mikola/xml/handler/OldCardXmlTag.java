package com.mikola.xml.handler;

public enum OldCardXmlTag {
    OLD_CARDS("old_cards"),
    AUTHOR("author"),
    THEMA("thema"),
    TYPE("type"),
    COUNTRY("country"),
    YEAR("year"),
    DIRECTION("direction"),
    MESSAGE("message");

    private String value;

    OldCardXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
