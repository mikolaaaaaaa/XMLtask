package com.mikola.xml.entity;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
public class SimpleOldCard extends OldCard {

    @XmlElement(name = "message",namespace = "old_cards")
    private String message;

    public SimpleOldCard() {

    }

    public SimpleOldCard(String id, String thema, String type, String country,
                         int year, String author, String message) {
        super(id, thema, type, country, year, author);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SimpleOldCard that = (SimpleOldCard) o;

        return getMessage() != null ? getMessage().equals(that.getMessage()) : that.getMessage() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("SimpleOldCard")
                .append(super.toString())
                .append(" ,message=").append(getMessage())
                .append("}")
                .toString();
    }

}
