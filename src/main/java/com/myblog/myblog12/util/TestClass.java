package com.myblog.myblog12.util;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class TestClass {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Adam", 35, "chennai"),
                new Employee("Smith", 36, "pune"),
                new Employee("Surya", 31, "Bangalore"),
                new Employee("George", 25, "UK")
        );
        List<Employee> emps = employees.stream().filter(emp -> emp.getName().endsWith("a")).collect(Collectors.toList());

        for (Employee e : emps) {
            System.out.println(e.getName());
            System.out.println(e.getAge());
            System.out.println(e.getCity());
        }
    }
}
