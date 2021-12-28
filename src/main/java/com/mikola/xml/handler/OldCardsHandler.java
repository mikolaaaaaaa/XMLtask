package com.mikola.xml.handler;

import com.mikola.xml.entity.Direction;
import com.mikola.xml.entity.OldCard;
import com.mikola.xml.entity.CongratulatoryOldCard;
import com.mikola.xml.entity.SimpleOldCard;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class OldCardsHandler extends DefaultHandler {
    private Set<OldCard> abstractOldCards;
    private OldCard current;
    private OldCardXmlTag currentXmlTag;
    private final EnumSet<OldCardXmlTag> withText;
    private static final String SIMPLE_OLD_CARD_ELEMENT = "simple_old_card";
    private static final String CONGRATULATORY_OLD_CARD_ELEMENT = "congratulatory_old_card";

    public OldCardsHandler() {
        abstractOldCards = new HashSet<>();
        withText = EnumSet.range(OldCardXmlTag.THEMA,OldCardXmlTag.MESSAGE);
    }

    public Set<OldCard> getAbstractOldCards() {
        return abstractOldCards;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
         if (SIMPLE_OLD_CARD_ELEMENT.equals(qName) || CONGRATULATORY_OLD_CARD_ELEMENT.equals(qName)) {
             current = SIMPLE_OLD_CARD_ELEMENT.equals(qName) ? new SimpleOldCard() : new CongratulatoryOldCard();
             int idPosition = 0;
             int authorPosition = 1;
             current.setId(attributes.getValue(idPosition));
             if (attributes.getLength() == 2) {
                 current.setAuthor(attributes.getValue(authorPosition));
             }
         }
         else {
             OldCardXmlTag temp = OldCardXmlTag.valueOf(qName.toUpperCase());
             if (withText.contains(temp)) {
                 currentXmlTag = OldCardXmlTag.valueOf(qName.toUpperCase());
             }
         }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (SIMPLE_OLD_CARD_ELEMENT.equals(qName) || CONGRATULATORY_OLD_CARD_ELEMENT.equals(qName)) {
            abstractOldCards.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)  {
        String data = new String(ch,start,length).strip();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case THEMA -> {
                    current.setThema(data);
                }
                case TYPE -> {
                    current.setType(data);
                }
                case COUNTRY -> {
                    current.setCountry(data);
                }
                case YEAR -> {
                    current.setYear(Integer.parseInt(data));
                }
                case AUTHOR -> {
                    current.setAuthor(data);
                }
                case DIRECTION -> {
                    ((CongratulatoryOldCard) current).setDirection(Direction.valueOf(data.toUpperCase()));
                }
                case MESSAGE -> {
                    ((SimpleOldCard) current).setMessage(data);
                }
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
        }
}


