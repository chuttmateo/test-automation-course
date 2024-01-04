package com.solvd.zoo.model.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {

    public static void main(String[] args) {

        System.out.println("---------------- employees ---------------");
        getDocumentValues("src/main/resources/xml/employee.xml", "employee");

        System.out.println("------------ visitors ----------------");
        getDocumentValues("src/main/resources/xml/visitor.xml", "visitor");

        System.out.println("---------------- species --------------");
        getDocumentValues("src/main/resources/xml/specie.xml", "specie");

        System.out.println("------------- veterinarians ----------");
        getDocumentValues("src/main/resources/xml/veterinarian.xml", "veterinarian");

        System.out.println("------------- enclosures -----------------");
        getDocumentValues("src/main/resources/xml/enclosure.xml", "enclosure");



    }
    public static void getDocumentValues(String url, String tagName){
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new File(url));
            doc.getDocumentElement().normalize();

            NodeList elementsByTagName = doc.getElementsByTagName(tagName);

            Node current;
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                current=elementsByTagName.item(i);
                if (current.getNodeType() == Node.ELEMENT_NODE){
                    getNodeData(current);
                }
            }
        }catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getNodeData(Node node){
        Node attribute = node.getAttributes().item(0);
        System.out.println(attribute.getNodeName() + ": " + attribute.getTextContent());
        NodeList childNodes = node.getChildNodes();
        Node current;
        for (int i = 0; i < childNodes.getLength(); i++) {
            current = childNodes.item(i);

            if (current.getNodeType() == Node.ELEMENT_NODE){
                System.out.println(current.getNodeName() + ": " + current.getTextContent());
                if (current.hasAttributes()){
                    System.out.println(current.getAttributes().item(0).getNodeName() + ": " + current.getAttributes().item(0).getTextContent());
                }
            }

        }
    }
}
