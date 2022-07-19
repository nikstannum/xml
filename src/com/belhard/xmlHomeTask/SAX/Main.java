package com.belhard.xmlHomeTask.SAX;

import com.belhard.xmlHomeTask.Employee;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("src/com/belhard/xmlHomeTask/resources/employees.xml")) {
            Handler handler = new Handler();
            List<Employee> list = handler.deserialize(in);
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
