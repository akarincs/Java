/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tienh
 */
public class Validation {

    private final static Scanner sc = new Scanner(System.in);
    private final static String VALID_USERNAME = "^\\S{5}\\S*$";
    private final static String VALID_PASSWORD = "^\\S{6}\\S*$";

    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;

            } catch (NumberFormatException e) {
                System.err.println("Password not in range");
                System.out.println("Enter again");
            }

        }
    }

    public static String checkinputString() {
        while (true) {

            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Can't blank");
                System.out.println("Enter String: ");

            } else {
                return result;
            }
        }
    }
     public static boolean checkFileExist() {
        File file = new File("D:/user.dat");
        if (!file.exists()) {
            try {
                System.err.println("File not exist!!!");
                file.createNewFile();
                System.err.println("File created.");
                return false;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }
     public static String checkInputUsername() {
        System.out.print("Enter username: ");
        //loop until user input correct
        while (true) {
            String result = checkinputString();
            if (result.matches(VALID_USERNAME)) {
                return result;
            }
            System.err.println("You must enter least at 5 character, and no space!");
            System.out.print("Enter again: ");
        }
    }

    //allow user input password
    public static String checkInputPassword() {
        System.out.print("Enter password: ");
        //loop until user input correct
        while (true) {
            String result = checkinputString();
            if (result.matches(VALID_PASSWORD)) {
                return result;
            }
            System.err.println("You must enter least at 6 character, and no space!");
            System.out.print("Enter again: ");
        }
    }

    //check username exist
    public static boolean checkUsernameExist(String username) {
        File file = new File("D:/user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return false;
                }
            }
            bufferedReader.close();
            fileReader.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
}
