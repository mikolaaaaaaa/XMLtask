package com.mikola.xml.entity;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "old_card",namespace = "old_cards")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({SimpleOldCard.class,CongratulatoryOldCard.class})
public class OldCard {
    @XmlAttribute(required = true)
    private String id;
    @XmlElement(name = "thema",namespace = "old_cards")
    private String thema;
    @XmlElement(name = "type",namespace = "old_cards")
    private String type;
    @XmlElement(name = "country",namespace = "old_cards")
    private String country;
    @XmlElement(name = "year",namespace = "old_cards")
    private int year;
    @XmlAttribute
    private String Author;

    public OldCard() {

    }

    public OldCard(String id, String thema, String type, String country, int year, String author) {
        this.id = id;
        this.thema = thema;
        this.type = type;
        this.country = country;
        this.year = year;
        Author = author;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThema() {
        return thema;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return Author;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("OldCard{")
                .append("id='").append(id)
                .append(", thema='").append(thema)
                .append(", type='").append(type)
                .append(", country='").append(country)
                .append(", year=").append(year)
                .append(", Author='").append(Author)
                .append('}')
                .toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        OldCard that = (OldCard) object;

        if (getYear() != that.getYear()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getThema() != null ? !getThema().equals(that.getThema()) : that.getThema() != null) return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null) return false;
        return getAuthor() != null ? getAuthor().equals(that.getAuthor()) : that.getAuthor() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getThema() != null ? getThema().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + getYear();
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        return result;
    }
}
