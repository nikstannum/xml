package com.belhard.xmlHomeTask.DOM;

import com.belhard.xmlHomeTask.Employee;
import java.io.OutputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.OutputKeys;

public class DOMWriter {
    public Document createDocument(List<Employee> list) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("employees");
            document.appendChild(root);
            list.forEach(employee -> serializeUser(document, employee, root));


            return document;
        } catch (
                ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public void serialize(Document document, OutputStream out, boolean formatter) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            if (formatter) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            }
            transformer.transform(new DOMSource(document), new StreamResult(out));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void serializeUser(Document doc, Employee empl, Element root) {
        Element emplElm = createEmplElm(doc, empl, root);
        processId(empl, emplElm);
        processFirstName(doc, empl, emplElm);
        processLastName(doc, empl, emplElm);
        processPhoneNumber(doc, empl, emplElm);
        processPassword(doc, empl, emplElm);
        processTag(doc, empl, emplElm);
        processUserRoleId(doc, empl, emplElm);
    }


    private Element createEmplElm(Document doc, Employee empl, Element root) {
        Element emplElm = doc.createElement("employee");
        root.appendChild(emplElm);
        return emplElm;
    }

    private void processId(Employee empl, Element emplElm) {
        emplElm.setAttribute("id", empl.getId().toString());
    }

    private void processFirstName(Document doc, Employee empl, Element emplElm) {
        Element elmFirstName = doc.createElement("firstName");
        emplElm.appendChild(elmFirstName);
        elmFirstName.setTextContent(empl.getFirstName());
    }

    private void processLastName(Document doc, Employee empl, Element emplElm) {
        Element elmLastName = doc.createElement("lastName");
        emplElm.appendChild(elmLastName);
        elmLastName.setTextContent(empl.getLastName());
    }

    private void processPhoneNumber(Document doc, Employee empl, Element emplElm) {
        Element phoneNumber = doc.createElement("phoneNumber");
        phoneNumber.setTextContent(empl.getPhoneNumber());
        emplElm.appendChild(phoneNumber);
    }

    private void processPassword(Document doc, Employee empl, Element emplElm) {
        Element passwordElm = doc.createElement("password");
        passwordElm.setTextContent(empl.getPassword());
        emplElm.appendChild(passwordElm);
    }

    private void processTag(Document doc, Employee empl, Element emplElm) {
        Element tagElm = doc.createElement("tag");
        tagElm.setTextContent(empl.getTag());
        emplElm.appendChild(tagElm);
    }

    private void processUserRoleId(Document doc, Employee empl, Element emplElm) {
        Element roleElm = doc.createElement("userRoleId");
        roleElm.setTextContent(empl.getUserRoleId().toString());
        emplElm.appendChild(roleElm);
    }


}
