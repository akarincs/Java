/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charlettercount;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
        
/**
 *
 * @author Dinh Nhat Hoang
 */
public class Charlettercount {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhập chuỗi");
        String s =sc.nextLine();
        Map<Character, Integer> charCount = new HashMap<>(); //đếm từ
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){ //xem nó là chữ hay số
                if(!charCount.containsKey(s.charAt(i)))
                    charCount.put(s.charAt(i),1);
                else
                    charCount.put(s.charAt(i),charCount.get(s.charAt(i))+1);   
            }
        }
        System.out.print("{");
        for (Map.Entry<Character, Integer>entry:charCount.entrySet())
            System.out.print(entry.getKey()+"="+entry.getValue()+", ");
        System.out.print("}");
        
        Map<String, Integer> wordCount = new HashMap<>(); //đếm chữ
        String[] word = s.split("[{#@} ]");
        for(String o : word){
            if(!wordCount.containsKey(o))
                wordCount.put(o, 1);
            else
                wordCount.put(o, wordCount.get(o)+1);   
        }
         System.out.print("{");
        for (Map.Entry<String, Integer>entry:wordCount.entrySet())
            System.out.print(entry.getKey()+"="+entry.getValue()+", ");
        System.out.print("}");                                                                         
    }   
}
