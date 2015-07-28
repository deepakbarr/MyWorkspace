package com.workspace.demos;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("A", 1);
        System.out.println(emp.toString());
    }

    public Employee getEmp() {
        return new Employee();
    }

}
