package com.belhard.xmlHomeTask.JAXB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryInMemory {
    private static final Map<Long, Employee> list = new HashMap<>();

    static {
        list.put(1L, new Employee(1L, "Mike", "Braun", "+375 29 1234567", "qwerty", "worker at factory", (byte) 19));
        list.put(2L, new Employee(2L, "Nick", "Johnson", "+1 158 5554567", "ytrewq", "policeman", (byte) 18));
        list.put(3L, new Employee(3L, "Arturs", "Karinsh", "+371 11 1112233", "password", "prime-minister",
                (byte) 17));
        list.put(4L, new Employee(4L, "Donald", "Trump", "+1 987 7654321", "great America again", "ex-president",
                (byte) 16));
        list.put(5L, new Employee(5L, "Joseph", "Biden", "+1 111 1111111", "White_House", "president",
                (byte) 15));
    }

    public Employee getByID(Long id) {
        return list.get(id);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(list.values());
    }

}
