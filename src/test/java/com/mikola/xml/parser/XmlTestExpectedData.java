package com.mikola.xml.parser;

import com.mikola.xml.entity.OldCard;
import com.mikola.xml.entity.CongratulatoryOldCard;
import com.mikola.xml.entity.Direction;
import com.mikola.xml.entity.SimpleOldCard;

import java.util.HashSet;
import java.util.Set;

public class XmlTestExpectedData {
    public Set<OldCard> oldCards = new HashSet<>();
    public final String path;

    public XmlTestExpectedData() {
        oldCards.add(new CongratulatoryOldCard("1","nature","congratulatory","Belarus",
                2002,"Mikola", Direction.NEW_YEAR));
        oldCards.add(new CongratulatoryOldCard("2","people","congratulatory","USA",
                2001,"Alex", Direction.BIRTHDAY));
        oldCards.add(new SimpleOldCard("3","nature","simple","USA",
                2000,"Peter", "for beautiful girl"));
        oldCards.add(new SimpleOldCard("4","sport","simple","Poland",
                2015,"Mike", "best wishes"));
        path = "src/test/resources/cards.xml";
    }

}
