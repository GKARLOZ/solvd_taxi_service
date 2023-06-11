package com.solvd.taxiservice.db.stax;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.solvd.taxiservice.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class XSDValidator {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        try {

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File( "src/main/resources/xml/xsd/" + xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File( "src/main/resources/xml/difXML/"+ xmlPath)));
        } catch (IOException e) {
            LOGGER.error("Exception: " + e.getMessage());
            return false;
        }catch(SAXException e1) {
            LOGGER.error("SAX Exception: " + e1.getMessage());
            return false;
        }

        return true;

    }

}
