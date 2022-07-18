package com.belhard.xmlHomeTask.DOM;

import com.belhard.xmlHomeTask.Employee;
import com.belhard.xmlHomeTask.EmployeeRepositoryInMemory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.w3c.dom.Document;

public class DOMDemo {
    public static final DOMWriter domWriter = new DOMWriter();
    public static final EmployeeRepositoryInMemory repo = new EmployeeRepositoryInMemory();
    public static final DOMReader domReader = new DOMReader();

    public static void main(String[] args) {

//write
//        try (OutputStream out = new FileOutputStream("src/com/belhard/xmlHomeTask/result/employeesDOM.xml")) {
//            List<Employee> list = repo.getAll();
//            Document doc = domWriter.createDocument(list);
//            domWriter.serialize(doc, out, true);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//read
        try (InputStream in = new FileInputStream("src/com/belhard/xmlHomeTask/resources/employees.xml")) {
            List<Employee> listRead = domReader.deserialize(in);
            listRead.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
