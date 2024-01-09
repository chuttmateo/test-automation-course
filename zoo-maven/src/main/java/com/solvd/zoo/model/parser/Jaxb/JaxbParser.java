package com.solvd.zoo.model.parser.Jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbParser {
    public static void marshall(Class<?> clazz, Object o, String fileName){
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            String filePath = String.format("src/main/resources/jaxb-xml/%s.xml", fileName);
            marshaller.marshal(o, new File(filePath));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object unmarshal(Class<?> clazz, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            return context.createUnmarshaller()
                    .unmarshal(new FileReader(path));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
