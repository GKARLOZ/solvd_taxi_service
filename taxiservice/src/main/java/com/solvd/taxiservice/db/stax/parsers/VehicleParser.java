package com.solvd.taxiservice.db.stax.parsers;

import com.solvd.taxiservice.db.model.Vehicle;
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

public class VehicleParser {
    private final static Logger LOGGER = LogManager.getLogger(VehicleParser.class);
        public void parse(String path){

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = null;
            Vehicle vehicle = null;
            try {

                reader = xmlInputFactory.createXMLEventReader(new FileInputStream( "src/main/resources/xml/difXML/" + path));

                while (reader.hasNext()) {
                    XMLEvent nextEvent = reader.nextEvent();
                    if (nextEvent.isStartElement()) {
                        StartElement startElement = nextEvent.asStartElement();
                        switch (startElement.getName().getLocalPart()) {
                            case "vehicle":
                                vehicle = new Vehicle();
                                Attribute id = startElement.getAttributeByName(new QName("id"));
                                if (id != null) {
                                    vehicle.setId(vehicle.getId());
                                }
                                break;
                            case "model":
                                nextEvent = reader.nextEvent();
                                vehicle.setModel(nextEvent.asCharacters().getData());
                                break;
                            case "licensePlate":
                                nextEvent = reader.nextEvent();
                                vehicle.setLicensePlate(nextEvent.asCharacters().getData());
                                break;

                        }
                    }
                    if (nextEvent.isEndElement()) {
                        EndElement endElement = nextEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals("vehicle")) {

                            LOGGER.info(vehicle);

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
