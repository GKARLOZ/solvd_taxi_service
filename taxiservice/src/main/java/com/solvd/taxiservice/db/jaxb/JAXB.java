package com.solvd.taxiservice.db.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXB {


    public void marshal(ManyUsersJAXB users)throws JAXBException{

            JAXBContext context = JAXBContext.newInstance(ManyUsersJAXB.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(users, new File("src/main/resources/JaxbResults.xml"));

    }




    public ManyUsersJAXB unmarshal() throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(ManyUsersJAXB.class);
        return (ManyUsersJAXB) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/JaxbResults.xml"));


    }

}
