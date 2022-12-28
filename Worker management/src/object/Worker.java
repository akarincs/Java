/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import com.sun.javafx.binding.StringFormatter;

/**
 *
 * @author tienh
 */
public class Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String location;
    public Worker(String id, String name, int age, double salary, String location) {
        this.age=age;
        this.id=id;
        this.location=location;
        this.name=name;
        this.salary=salary;
    }

    public Worker() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
         return String.format("%s|%-8s|%2d|%-7.1f|%15s1"
                 + id,name,age,salary,location);
    }

    
    
    
    
    
}
