/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import object.SalaryHistory;
import object.Worker;

/**
 *
 * @author tienh
 */
public class Management {

    final double MIN = 0.00001;
    private Scanner sc = new Scanner(System.in);
    private List<Worker> wList;
    private List<SalaryHistory> shList;

    public Management() {
        wList = new ArrayList<>();
        shList = new ArrayList<>();
    }

    public void addWorker() {
        String id, name, location;
        int age;
        double salary;
        id = Validation.getString("Enter worker id: ", "Id should be unique: ", wList, 1);
        System.out.println("Enter worker name: ");
        name = sc.nextLine();
        age = Validation.checkIntLimit("Enter worker age: ", 18, 50);
        salary = Validation.getDouble("Enter worker salary", MIN, Double.MAX_VALUE);
        System.out.println("Enter work location: ");
        location = sc.nextLine();
        wList.add(new Worker(id, name, age, salary, location));
    }

    public void updateSalary(int mode) {
        String id = Validation.getString("Enter worker id to update salary: ", "ID must exist in database", wList, 2);
        double money = Validation.getDouble("Amount: ", MIN, Double.MAX_VALUE);
        double update = 0;
        String status = "";
        Worker o = Validation.getWorker(id, wList);
        if (mode == 1) {
            update = o.getSalary() + money;
            status = "UP";
        } else if (mode == 2) {
           update=Validation.getDouble("Enter amount: ", 1,o.getSalary());
            if (o.getSalary() > money) {
                update = o.getSalary() - money;
                status = "Down";
            }

        }
        o.setSalary(update);
        shList.add(new SalaryHistory(id, o.getName(), o.getAge(), o.getSalary(), status, java.time.LocalDate.now()));
    }

    public void loadFromFile() throws FileNotFoundException, IOException {
        File f = new File("person.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] info = line.split("[, ]");

            String id = info[0].trim();
            System.out.println(id);
            String name = info[1].trim();
            System.out.println(name);

            int age = Integer.parseInt(info[2].trim());
            double salary = Double.parseDouble(info[3].trim());
            String location = info[4].trim();
            wList.add(new Worker(id, name, age, salary, location));

        }
        br.close();
        fr.close();
    }

    public void saveToFile() throws IOException {
        File f = new File("person.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Worker p : wList) {
            bw.write(p.toString());
        }
        bw.close();
        fw.close();

    }

    public void getInformation() {
        display(shList);
    }

    public void displayAll() {
        display(wList);
    }

    private void display(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
    

}
