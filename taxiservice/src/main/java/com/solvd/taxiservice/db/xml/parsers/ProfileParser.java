package com.solvd.taxiservice.db.xml.parsers;

import com.solvd.taxiservice.Main;
import com.solvd.taxiservice.db.model.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProfileParser {
    private final static Logger LOGGER = LogManager.getLogger(ProfileParser.class);
    public void parse(String path){

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = null;
        Profile profile = null;
        try {

            reader = xmlInputFactory.createXMLEventReader(new FileInputStream( "src/main/java/com/solvd/taxiservice/db/xml/difXML/" + path));

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "profile":
                        profile = new Profile();
                        Attribute id = startElement.getAttributeByName(new QName("id"));
                        if (id != null) {
                            profile.setId(profile.getId());
                        }
                        break;
                    case "name":
                        nextEvent = reader.nextEvent();
                        profile.setName(nextEvent.asCharacters().getData());
                        break;
                    case "phoneNumber":
                        nextEvent = reader.nextEvent();
                        profile.setPhoneNumber(nextEvent.asCharacters().getData());
                        break;

                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("profile")) {

                    LOGGER.info(profile);

                }
            }
        }
        } catch (XMLStreamException e) {
            LOGGER.error(e);
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        }


    }


}
