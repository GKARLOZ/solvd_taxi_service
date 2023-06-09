package com.solvd.taxiservice.db.xml.parsers;

import com.solvd.taxiservice.Main;
import com.solvd.taxiservice.db.model.DriverLicense;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverLicenseParser {
    private final static Logger LOGGER = LogManager.getLogger(DriverLicenseParser.class);
    public void parse(String path){

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = null;
        DriverLicense dl = null;
        try {

            reader = xmlInputFactory.createXMLEventReader(new FileInputStream( "src/main/java/com/solvd/taxiservice/db/xml/difXML/" + path));

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "driverLicense":
                            dl = new DriverLicense();
                            Attribute id = startElement.getAttributeByName(new QName("id"));
                            if (id != null) {
                                dl.setId(dl.getId());
                            }
                            break;
                        case "licenseNumber":
                            nextEvent = reader.nextEvent();
                            dl.setLicenseNumber(nextEvent.asCharacters().getData());
                            break;
                        case "dateOfBirth":
                            nextEvent = reader.nextEvent();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date dateOfBirth = dateFormat.parse(nextEvent.asCharacters().getData());
                            dl.setDateOfBirth(dateOfBirth);
                            break;
                        case "expirationDate":
                            nextEvent = reader.nextEvent();
                            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            dateOfBirth = dateFormat.parse(nextEvent.asCharacters().getData());
                            dl.setExpirationDate(dateOfBirth);
                            break;

                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("driverLicense")) {

                        LOGGER.info(dl);

                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.error(e);
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        } catch (ParseException e) {
            LOGGER.error(e);
        }


    }


}
