package com.example.firststartandroid.model;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private double salary;
    private String dateOfBirth;
    private String phone;
    private String status;

    public Employee() { }

    public Employee(String id, String firstName, String lastName, String address,
                    double salary, String dateOfBirth, String phone, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.status = status;
    }

    // Getters and setters for all fields (generate via IDE or manually)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

