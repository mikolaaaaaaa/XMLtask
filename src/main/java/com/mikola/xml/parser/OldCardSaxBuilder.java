package com.mikola.xml.parser;

import com.mikola.xml.entity.OldCard;
import com.mikola.xml.handler.OldCardsHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class OldCardSaxBuilder implements OldCardBuilder{
    private static final Logger logger = LogManager.getLogger();
    private Set<OldCard> oldCards;
    private final OldCardsHandler handler = new OldCardsHandler();
    private XMLReader reader;

    public Set<OldCard> getOldCards() {
        return oldCards;
    }

    @Override
    public void buildSetOldCards(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
        }catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        reader.setContentHandler(handler);
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        oldCards = handler.getAbstractOldCards();
        logger.info("oldCard collection was created, the data from the XML file {} was read successfully",filename);
    }
}
