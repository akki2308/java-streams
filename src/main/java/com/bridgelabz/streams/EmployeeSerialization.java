package com.bridgelabz.streams;

import java.io.*;
        import java.util.ArrayList;
        import java.util.List;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display Employee details
    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Department='" + department + '\'' +
                ", Salary=" + salary +
                '}';
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.ser";

    // Serialize list of employees to a file
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Deserialize employees from a file
    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 70000));
        employees.add(new Employee(103, "Charlie", "Finance", 60000));

        // Serialize employees
        serializeEmployees(employees);

        // Deserialize and display employees
        List<Employee> deserializedEmployees = deserializeEmployees();
        System.out.println("Retrieved Employees:");
        for (Employee emp : deserializedEmployees) {
            System.out.println(emp);
        }
    }
}
