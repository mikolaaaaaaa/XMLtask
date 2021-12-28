package com.mikola.xml.entity;

public enum Direction {
    NEW_YEAR("new_year"),
    BIRTHDAY("birthday"),
    CHRISTMAS("christmas"),
    BEER_DAY("beer_day");

    private String value;

    Direction() {}

    Direction(String value) {
        this.value = value;
    }
}
