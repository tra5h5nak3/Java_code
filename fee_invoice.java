package now;

import java.util.Scanner;
public class fee_invoice {
	
	public static void main (String [] args) {
		
		Scanner myScan = new Scanner (System.in);
		String [] items1;
		String [] items2;
		
		int num1,num2,num3,num4;
		double num5;
		double num6, total;
		
		String id;
		String name;
		
		String crn1;
		String crn2;
		
		
		System.out.print("Enter the Student’s Id: ");
		id = myScan.nextLine();
		
		System.out.print("Enter the Student’s full name: ");
		name = myScan.nextLine();
		
		System.out.print("Enter crn/credit hours for the first class(like 5665/3:");
		crn1 = myScan.nextLine();
		
		System.out.print("Enter crn/credit hours for the second class(like 5665/3):");
		crn2 = myScan.nextLine();
		
		items1 = crn1.split("/");
		items2 = crn2.split("/");
		
		num1 = Integer.parseInt(items1[0]);
		num2 = Integer.parseInt(items1[1]);
		
		num3 = Integer.parseInt(items2[0]);
		num4 = Integer.parseInt(items2[1]);
		
		num5 = (double) (num2 * 120.25);
		num6 = (double) (num4 * 120.25);
		total = num5 + num6 + 35.00;
		
		
		System.out.print("SIMPLE COLLEGE \nORLANDO FL 10101");
		System.out.print("\n*************************\n\n");
		System.out.print("Fee Invoice Prepared for: \n");
		System.out.print("[" + name + "] [" + id + "]\n");
		System.out.print("\n1 Credit Hour = $120.25\n\n");
		System.out.print("CRN\tCREDIT HOURS\n");
		System.out.print(num1 + "\t" + num2 + "\t\t\t$" + num5 + "\n");
		System.out.print(num3 + "\t" + num4 + "\t\t\t$" + num6);
		System.out.print( "\n\n\tHealth & id fees" + "\t$35.00" );
		System.out.print("\n\n----------------------------------------");
		System.out.print("\n\tTotal Payments\t\t" + total);
		
		
		
		 
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
