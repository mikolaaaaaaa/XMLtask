package com.mikola.xml.parser;

import com.mikola.xml.entity.OldCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class OldCardDomBuilderTest {
    private final XmlTestExpectedData expectedData = new XmlTestExpectedData();

    @Test
    public void testBuildOldCardsCollectOldCardToSet() {
        Set<OldCard> expected = expectedData.oldCards;
        OldCardDomBuilder builder = new OldCardDomBuilder();
        builder.buildSetOldCards(expectedData.path);
        Set<OldCard> actual = builder.getOldCards();
        Assertions.assertEquals(expected,actual);
    }
}
