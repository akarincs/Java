/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.List;
import java.util.Scanner;
import object.Worker;

/**
 *
 * @author tienh
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int checkIntLimit(String msg, int min, int max) {
        int result;
        while (true) {
            try {
                System.out.println(msg);
                result = Integer.parseInt(sc.nextLine().trim());
                if (min <=result || result <= max) {
                    break;
                }
                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range: " + min+"-->" + max);
                System.out.println("Enter again");
            }

        }
        return result;
    }

    public static double getDouble(String msg, double min, double max) {
        int result;
        while (true) {
            try {
                System.out.println(msg);
                result = Integer.parseInt(sc.nextLine().trim());
                if (min <=result || result <= max) {
                    break;
                }
                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range: " + min+"-->" + max);
                System.out.println("Enter again");
            }

        }
        return result;
    }

    public static String getString(String msg,String err, List<Worker> wList, int mode) {
        String n;
        while (true) {
            System.out.println(msg);
            n = sc.nextLine();
            if (!n.isEmpty()) {
                //1:input id not exist
                //2:update - id must exist
                if ((mode == 1 && getWorker(n, wList)==null) || (mode == 2 && getWorker(n, wList)!=null)) {
                    break;
                }
                System.err.println(err);
            }
        }
        return n;
    }

    public static Worker getWorker(String id, List<Worker> wList) {
        for(Worker o : wList){
            if(o.getId().equals(id))
                return o;
            
        }
        return null;
    }

}
