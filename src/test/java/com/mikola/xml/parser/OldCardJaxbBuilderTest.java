package com.mikola.xml.parser;

import com.mikola.xml.entity.OldCard;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Set;

public class OldCardJaxbBuilderTest {
    XmlTestExpectedData data = new XmlTestExpectedData();

    @Test
    public void testBuildSetOldCardsShouldReturnCollectOfOldCardsFromXml() throws JAXBException {

        OldCardJaxbBuilder builder = new OldCardJaxbBuilder();
        builder.buildSetOldCards(data.path);
        Set<OldCard> actual = builder.getOldCards();
        Set<OldCard> expected = data.oldCards;
        Assertions.assertEquals(expected, actual);

    }
}
