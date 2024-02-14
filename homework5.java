import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.io;

public class homework5 {


    public static void main (String [] array) {

        File file = new File ("/Users/bryce/Desktop/folderJ/now");

        Scanner scanner2 = null;

        String data = "100 Anystreet 100 what 100 balls";
        Scanner scanner = new Scanner (data);

        try{
            scanner2 = new Scanner(file);
        } catch (Execution a){
            System.out.println("File Not Found...");
        }


        int number = 0, sum = 0;
        String word;


        while(scanner2.hasNextLine()){
            try{
                word = scanner2.next();
                number = Integer.parseInt(word);
                sum+= number;
            } catch (Exception b){
                System.out.println("Oooops! ");
            }
        }


        

        

        /* 

        while(scanner.hasNext()){
            try{
                word = scanner.next();
                number = Integer.parseInt(word);
                sum+= number;
            } catch(Exception e){
                System.out.println("OOPS ");
            }
        }
        */


        System.out.println("\nThe Sum is " + sum);

        scanner.close();
        scanner2.close();


    }
    
}
