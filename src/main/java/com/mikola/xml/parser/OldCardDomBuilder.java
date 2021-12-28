package com.mikola.xml.parser;

import com.mikola.xml.entity.Direction;
import com.mikola.xml.entity.OldCard;
import com.mikola.xml.entity.CongratulatoryOldCard;
import com.mikola.xml.entity.SimpleOldCard;
import com.mikola.xml.handler.OldCardXmlTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class OldCardDomBuilder implements OldCardBuilder {
    private static final Logger logger = LogManager.getLogger();
    private Set<OldCard> oldCards = new HashSet<>();
    private OldCardXmlTag oldCardXmlTag;
    private DocumentBuilder documentBuilder;
    private final String XML_SIMPLE_OLD_CARD = "simple_old_card";
    private final String XML_CONGRATULATORY_OLD_CARD = "congratulatory_old_card";
    private final String SIMPLE_OLD_CARD = "SimpleOldCard";
    private final String CONGRATULATORY_OLD_CARD = "CongratulatoryOldCard";

    public Set<OldCard> getOldCards() {
        return oldCards;
    }

    @Override
    public void buildSetOldCards(String filename) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        try {
            documentBuilder = factory.newDocumentBuilder();
            document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList simpleOldCardsList = root.getElementsByTagName(XML_SIMPLE_OLD_CARD);
            parseElement(simpleOldCardsList);
            NodeList congratulatoryOldCardsList = root.getElementsByTagName(XML_CONGRATULATORY_OLD_CARD);
            parseElement(congratulatoryOldCardsList);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        logger.info("oldCard collection was created, the data from the XML file {} was read successfully",filename);
    }

    private void parseElement(NodeList oldCardList) throws IOException {

        for (int i = 0; i < oldCardList.getLength(); i++) {
            Element oldCardElement = (Element) oldCardList.item(i);
            Optional<OldCard> data = buildOldCard(oldCardElement);
            if (data.isPresent()) {
                oldCards.add(data.get());
            } else {
                throw new IOException("Element is null");
            }
        }

    }

    public Optional<OldCard> buildOldCard(Element oldCardElement) {
        if (oldCardElement == null) {
            return Optional.empty();
        }
        String tagName = oldCardElement.getTagName();
        OldCard current = XML_SIMPLE_OLD_CARD.equals(tagName) ? new SimpleOldCard() : new CongratulatoryOldCard();
        current.setId(oldCardElement.getAttribute("id"));
        current.setAuthor(oldCardElement.getAttribute("author"));
        current.setThema(getElementTextContent(oldCardElement, "thema"));
        current.setType(getElementTextContent(oldCardElement, "type"));
        current.setCountry(getElementTextContent(oldCardElement, "country"));
        int year = Integer.parseInt(getElementTextContent(oldCardElement, "year"));
        current.setYear(year);
        if (current instanceof SimpleOldCard) {
            ((SimpleOldCard) current).setMessage(getElementTextContent(oldCardElement, "message"));
        } else {
            ((CongratulatoryOldCard) current).setDirection(Direction.valueOf(getElementTextContent(oldCardElement, "direction").toUpperCase()));
        }
        return Optional.of(current);
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
