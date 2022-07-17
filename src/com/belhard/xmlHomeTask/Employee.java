package com.belhard.xmlHomeTask;

import java.util.Objects;

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String tag;
    private Byte userRoleId;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String phoneNumber, String password, String tag, Byte userRoleId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.tag = tag;
        this.userRoleId = userRoleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Byte getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Byte userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id)
                && Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName)
                && Objects.equals(phoneNumber, employee.phoneNumber)
                && Objects.equals(userRoleId, employee.userRoleId);
    }

    @Override
    public int hashCode() {
        int result = (int) (id * 31);
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "id = " + id +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", phoneNumber = " + phoneNumber +
                ", password = " + password +
                ", tag = " + tag +
                ", userRoleId = " + userRoleId;
    }
}
