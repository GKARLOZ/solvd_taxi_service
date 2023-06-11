package com.solvd.taxiservice.db.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class JAXB {


    public void marshal(DriverLicenseJAXB dl)throws JAXBException{

            JAXBContext context = JAXBContext.newInstance(DriverLicenseJAXB.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(dl, new File("src/main/resources/JAXBresults.xml"));

    }




    public DriverLicenseJAXB unmarshal() throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(DriverLicenseJAXB.class);
        return (DriverLicenseJAXB) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/JAXBresults.xml"));


    }

}
