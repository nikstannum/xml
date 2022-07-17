package com.belhard.xmlHomeTask.StAXDemo;

import com.belhard.xmlHomeTask.Employee;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXReader {
    public List<Employee> deserialize(InputStream in) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(in);
            List<Employee> list = new ArrayList<>();
            Employee employee = null;
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String elementName = startElement.getName().getLocalPart();
                    switch (elementName) {
                        case "employee": {
                            employee = processEmployee(startElement, list);
                            break;
                        }
                        case "firstName": {
                            processFirstName(reader, employee);
                            break;
                        }
                        case "lastName": {
                            processLastName(reader, employee);
                            break;
                        }
                        case "phoneNumber": {
                            processPhoneNumber(reader, employee);
                            break;
                        }
                        case "password": {
                            processPassword(reader, employee);
                            break;
                        }
                        case "tag": {
                            processTag(reader, employee);
                            break;
                        }
                        case "userRoleId": {
                            processUserRoleId(reader, employee);
                            break;
                        }
                    }
                }
            }
            return list;
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    private void processFirstName(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setFirstName(reader.getElementText());
    }

    private void processLastName(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setLastName(reader.getElementText());
    }

    private void processPhoneNumber(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setPhoneNumber(reader.getElementText());
    }

    private void processPassword(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setPassword(reader.getElementText());
    }

    private Employee processEmployee(StartElement startElement, List<Employee> list) {
        Employee employee = new Employee();
        employee.setId(Long.parseLong(startElement.getAttributeByName(new QName("id")).getValue()));
        list.add(employee);
        return employee;
    }

    private void processTag(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setTag(reader.getElementText());
    }

    private void processUserRoleId(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setUserRoleId(Byte.parseByte(reader.getElementText()));
    }

}
