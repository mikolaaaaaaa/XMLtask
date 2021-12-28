package com.mikola.xml.entity;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
public class CongratulatoryOldCard extends OldCard {

    @XmlElement(namespace = "old_cards")
    private Direction direction;

    public CongratulatoryOldCard() {

    }

    public CongratulatoryOldCard(String id,String thema, String type, String country,
                                 int year, String author, Direction direction) {
        super(id,thema, type, country, year, author);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        CongratulatoryOldCard that = (CongratulatoryOldCard) object;

        return getDirection() != null ? getDirection().equals(that.getDirection()) : that.getDirection() == null;
    }

    @Override
    public int hashCode() {
        int result = getDirection() == null ? 17 : getDirection().hashCode();
        result = result * 31 + super.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("CongratulatoryOldCard{")
                .append(super.toString())
                .append(" ,direction=").append(getDirection())
                .append("}")
                .toString();

    }
}
