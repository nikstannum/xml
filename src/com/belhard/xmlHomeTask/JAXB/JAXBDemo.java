package com.belhard.xmlHomeTask.JAXB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBDemo {
    public static final EmployeeRepositoryInMemory repo = new EmployeeRepositoryInMemory();

    public static void main(String[] args) {
        read();
        write();
    }

    private static void write() {
        try (OutputStream out = new FileOutputStream("src/com/belhard/xmlHomeTask/result/JAXBemployees.xml")) {
            JAXBContext content = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = content.createMarshaller();

            List<Employee> list = repo.getAll();
            Employees employeesSerial = new Employees(list);

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(employeesSerial, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void read() {
        try (InputStream in = new FileInputStream("src/com/belhard/xmlHomeTask/resources/employees.xml")) {
            JAXBContext content = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = content.createUnmarshaller();

            Employees employeesDeserial = (Employees) unmarshaller.unmarshal(in);

            List<Employee> list = employeesDeserial.getList();
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
