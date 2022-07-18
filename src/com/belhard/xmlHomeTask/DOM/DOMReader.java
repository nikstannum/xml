package com.belhard.xmlHomeTask.DOM;

import com.belhard.xmlHomeTask.Employee;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMReader {
    public List<Employee> deserialize(InputStream in) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(in);
            List<Employee> list = new ArrayList<>();
            Element root = document.getDocumentElement();
            NodeList nodes = root.getElementsByTagName("employee");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element emplElm = (Element) nodes.item(i);
                Employee employee = processEmpl(emplElm);
                list.add(employee);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Employee processEmpl(Element emplElm) {
        Employee employee = new Employee();
        employee.setId(getId(emplElm));
        employee.setFirstName(getFirstName(emplElm));
        employee.setLastName(getLastName(emplElm));
        employee.setPhoneNumber(getPhoneNumber(emplElm));
        employee.setPassword(getPassword(emplElm));
        employee.setTag(getTag(emplElm));
        employee.setUserRoleId(getUserRoleId(emplElm));
        return employee;
    }

    private Long getId(Element emplElm) {
        String rawId = emplElm.getAttribute("id");
        Long id = Long.parseLong(rawId);
        return id;
    }

    private String getFirstName(Element emplElm) {
        Element firstNameElm = (Element) emplElm.getElementsByTagName("firstName").item(0);
        String firstName = firstNameElm.getTextContent();
        return firstName;
    }

    private String getLastName(Element emplElm) {
        Element lastNameElm = (Element) emplElm.getElementsByTagName("lastName").item(0);
        String lastName = lastNameElm.getTextContent();
        return lastName;
    }

    private String getPhoneNumber(Element emplElm) {
        Element phoneNumElm = (Element) emplElm.getElementsByTagName("phoneNumber").item(0);
        return phoneNumElm.getTextContent();
    }

    private String getPassword(Element emplElm) {
        Element passwordElm = (Element) emplElm.getElementsByTagName("password").item(0);
        return passwordElm.getTextContent();
    }

    private String getTag(Element emplElm) {
        Element tagElm = (Element) emplElm.getElementsByTagName("tag").item(0);
        return tagElm.getTextContent();
    }

    private Byte getUserRoleId(Element emplElm) {
        Element roleIdElm = (Element) emplElm.getElementsByTagName("userRoleId").item(0);
        return Byte.parseByte(roleIdElm.getTextContent());
    }
}
