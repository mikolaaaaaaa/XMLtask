package com.mikola.xml.parser;

import com.mikola.xml.entity.OldCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class OldCardSaxBuilderTest {
   private final XmlTestExpectedData expectedData = new XmlTestExpectedData();
    @Test
    public void testBuildOldCardsShouldCreateSetOfOldCards() {

        System.out.println(OldCard.class.getName());
        Set<OldCard> expected = expectedData.oldCards;
        OldCardSaxBuilder builder = new OldCardSaxBuilder();
        builder.buildSetOldCards(expectedData.path);
        Set<OldCard> actual = builder.getOldCards();
        Assertions.assertEquals(expected,actual);

    }

}
