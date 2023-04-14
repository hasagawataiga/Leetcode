package Interview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class interview{
    public static void main(String[] args){
        // print 1 - 100
        // i % 3 -> fizz
        // i % 5 -> buzz
        // both ->> fizzbuzz
        // 
        // Read the number from file
        String fileName = "user.txt";
        String result = "";
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            if (line != null){
                int input = Integer.parseInt(line);
                if (input % 15 == 0){
                    result = "FizzBuzz";
                } else if (input % 5 == 0){
                    result = "Buzz";
                } else if (input % 3 == 0){
                    result = "Fizz";
                } else {
                    result = line + "";
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        // Write the result to file
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result);
        } catch (Exception e){
            e.printStackTrace();
        }
        

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter number:");
        // int input = sc.nextInt();
        // if (input % 15 == 0){
        //     System.out.println("FizzBuzz");
        // } else if (input % 5 == 0){
        //     System.out.println("Buzz");
        // } else if (input % 3 == 0){
        //     System.out.println("Fizz");
        // } else {
        //     System.out.println(input);
        // }

        // int n = 100;
        // for (int i = 1; i <= input; i++){
        //     if (i % 15 == 0){
        //         System.out.println("FizzBuzz");
        //     } else if (i % 5 == 0){
        //         System.out.println("Buzz");
        //     } else if (i % 3 == 0){
        //         System.out.println("Fizz");
        //     } else {
        //         System.out.println(i);
        //     }
        // }
    }
}