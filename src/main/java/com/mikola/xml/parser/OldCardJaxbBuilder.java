package com.mikola.xml.parser;

import com.mikola.xml.entity.OldCard;
import com.mikola.xml.entity.OldCardWrapper;
import jakarta.xml.bind.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.HashSet;
import java.util.Set;


public class OldCardJaxbBuilder implements OldCardBuilder {
    private static final Logger logger = LogManager.getLogger();
    private Set<OldCard> oldCards;

    public Set<OldCard> getOldCards() {
        return oldCards;
    }

    @Override
    public void buildSetOldCards(String filename) {
        OldCardWrapper oldCardWrapper = new OldCardWrapper();
        try {
            JAXBContext context = JAXBContext.newInstance(OldCardWrapper.class);
            Unmarshaller unMarshaller = context.createUnmarshaller();
            oldCardWrapper = (OldCardWrapper) unMarshaller.unmarshal(new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        logger.info("oldCard collection was created, the data from the XML file {} was read successfully",filename);
        oldCards = new HashSet<>(oldCardWrapper.getList());
    }
}
