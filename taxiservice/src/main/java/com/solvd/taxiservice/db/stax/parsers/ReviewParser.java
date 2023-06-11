package com.solvd.taxiservice.db.stax.parsers;

import com.solvd.taxiservice.db.model.Review;
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

public class ReviewParser {
    private final static Logger LOGGER = LogManager.getLogger(ReviewParser.class);
    public void parse(String path){

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = null;
        Review review = null;
        try {

            reader = xmlInputFactory.createXMLEventReader(new FileInputStream( "src/main/resources/xml/difXML/" + path));

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "review":
                            review = new Review();
                            Attribute id = startElement.getAttributeByName(new QName("id"));
                            if (id != null) {
                                review.setId(review.getId());
                            }
                            break;
                        case "rating":
                            nextEvent = reader.nextEvent();
                            review.setRating(Integer.parseInt(nextEvent.asCharacters().getData()));
                            break;
                        case "comment":
                            nextEvent = reader.nextEvent();
                            review.setComment(nextEvent.asCharacters().getData());
                            break;

                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("review")) {

                        LOGGER.info(review);

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
