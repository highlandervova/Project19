package main;

import com.google.gson.Gson;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File xmlDocument = new File("company.xml");


        JAXBContext context = JAXBContext.newInstance(Company.class);
        Unmarshaller um = context.createUnmarshaller();
        Company c = (Company) um.unmarshal(xmlDocument);
        System.out.println(c);

//        final Company c = new Company();

//        parser.parse(xmlDocument, new DefaultHandler() {
//            Department dep = null;
//            Employee emp = null;
//            boolean isInLocation = false;
//            boolean isInName = false;
//
//            @Override
//            public void startElement(String s, String s1, String tagName, Attributes attributes) throws SAXException {
//                switch (tagName) {
//                    case "company":
//                        c.setName(attributes.getValue("name"));
//                        break;
//                    case "director":
//                        c.setDirector(new Director(attributes.getValue("name"), Integer.valueOf(attributes.getValue("age"))));
//                        break;
//                    case "departments":
//                        c.setDepartments(new ArrayList<>());
//                        break;
//                    case "department":
//                        Department d = new Department();
//                        d.setId(Integer.valueOf(attributes.getValue("id")));
//                        d.setName(attributes.getValue("name"));
//                        c.getDepartments().add(d);
//                        dep = d;
//                        break;
//                    case "location":
//                        isInLocation = true;
//                        break;
//                    case "employees":
//                        dep.setEmployees(new ArrayList<>());
//                        break;
//                    case "employee":
//                        Employee e = new Employee();
//                        e.setId(Integer.valueOf(attributes.getValue("id")));
//                        dep.getEmployees().add(e);
//                        emp = e;
//                        break;
//                    case "name":
//                        isInName = true;
//                        break;
//                }
//            }
//
//            @Override
//            public void endElement(String s, String s1, String tagName) throws SAXException {
//                switch (tagName) {
//                    case "location":
//                        isInLocation = false;
//                        break;
//                    case "name":
//                        isInName = false;
//                        break;
//                }
//            }
//
//            @Override
//            public void characters(char[] chars, int start, int length) throws SAXException {
//                StringBuilder s = new StringBuilder(length);
//                for (int i = start; i < start+length; i++) {
//                    s.append(chars[i]);
//                }
//                if (isInLocation) {
//                    dep.setLocation(s.toString());
//                }
//                if (isInName) {
//                    emp.setName(s.toString());
//                }
//            }
//        });
//
//        String jsonDocument = new Gson().toJson(c);
//        System.out.println(jsonDocument.length());
//        System.out.println(xmlDocument.length());
//
//        System.out.println(jsonDocument);
    }
}
