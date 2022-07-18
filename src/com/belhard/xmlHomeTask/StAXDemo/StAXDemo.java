package com.belhard.xmlHomeTask.StAXDemo;

import com.belhard.xmlHomeTask.Employee;
import com.belhard.xmlHomeTask.EmployeeRepositoryInMemory;

import java.util.List;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StAXDemo {
    private static final StAXReader reader = new StAXReader();
    private static final EmployeeRepositoryInMemory repo = new EmployeeRepositoryInMemory();
    private static final StAXWriter writer = new StAXWriter();

    public static void main(String[] args) {
        // read
        try (InputStream in = new FileInputStream("src/com/belhard/xmlHomeTask/resources/employees.xml")) {
            List<Employee> list = reader.deserialize(in);
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write
        try (OutputStream out = new FileOutputStream("src/com/belhard/xmlHomeTask/result/employees.xml")) {
            List<Employee> employees = repo.getAll();
            writer.serialize(employees, out);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
