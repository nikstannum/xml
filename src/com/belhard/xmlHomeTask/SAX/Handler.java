package com.belhard.xmlHomeTask.SAX;

import com.belhard.xmlHomeTask.Employee;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


public class Handler extends DefaultHandler {

    private List<Employee> list;
    private String element;
    private Employee employee;
    private StringBuilder text;


    public List<Employee> deserialize (InputStream in) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(in, this);
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        switch (element) {
            case "employees": {
                break;
            }
            case "employee": {
                employee = new Employee();
                list.add(employee);
                String rawId = attributes.getValue("id");
                Long id = Long.parseLong(rawId);
                employee.setId(id);
                break;
            }
            default:
                text = new StringBuilder();
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String content = text.toString();
        switch (element) {
            case "firstName": {
                employee.setFirstName(content);
                break;
            }
            case "lastName": {
                employee.setLastName(content);
                break;
            }
            case "phoneNumber": {
                employee.setPhoneNumber(content);
                break;
            }
            case "password": {
                employee.setPassword(content);
                break;
            }
            case "tag": {
                employee.setTag(content);
                break;
            }
            case "userRoleId": {
                employee.setUserRoleId(Byte.parseByte(content));
                break;
            }
        }
        element = "";
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (text != null) {
            text.append(ch, start, length);
        }
    }
}
