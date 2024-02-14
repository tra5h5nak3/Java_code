package oopFolder;

/*
-	Final Project 
-	Pavan Tamma and Bryce Kelly
*/


import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class oopProject {

	public static void main(String[] args) throws FileNotFoundException{	
		PersonList list = new PersonList();
		int listNum = 0;
		PrintWriter ReportOutput = new PrintWriter("report.txt");
		SimpleDateFormat dateFormatter= new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date(System.currentTimeMillis());
		
		
		Scanner myScan = new Scanner(System.in);
		Scanner dataScan = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		Scanner scan5 = new Scanner(System.in); 
		Scanner scan6 = new Scanner(System.in); 
		Scanner scan7 = new Scanner(System.in); 
		Scanner scan8 = new Scanner(System.in); 
		Scanner scan9 = new Scanner(System.in); 
		Scanner scan10 = new Scanner(System.in); 
		
		
		int input = 0;
		System.out.println("Choose one of the options:");
		
		while(input != 8) {
			System.out.println("1- Enter the information of a faculty\n"
					+ "2- Enter the information of a student\n"
					+ "3- Print tuition invoice for a student\n"
					+ "4- Print faculty information\n"
					+ "5- Enter the information of a staff member\n"
					+ "6- Print the information of a staff member\n"
					+ "7- Delete a Person\n"
					+ "8- Exit Program\n");
			
			System.out.println("Enter your selection: ");
			
			scan4.reset();
			scan3.reset();
			dataScan.reset();
			myScan.reset();
			scan5.reset();
			scan6.reset();
			input = 10;
			try {
				input = scan4.nextInt();
				
				
			}catch(Exception e) {
				
				String input2 = scan4.next();
				System.out.print("\n");
				
			}
			
			if (input == 1) {
				System.out.println("Name of faculty: ");
				String name = scan6.nextLine();
				
				System.out.println("ID: ");
				String id = scan5.nextLine();
				
				
				boolean boof = false;
				String rank = null;
				while(boof == false) {
					System.out.println("Rank: ");
					rank = scan7.nextLine();
					try {
						if((rank.compareToIgnoreCase("professor") == 0) || (rank.compareToIgnoreCase("adjunct")==0) ) {
							break;
						}
						System.out.println("'" + rank + "' is invalid");
						
					}catch(Exception e) {
						System.out.println("'" + rank + "' is invalid");
					}
					
				}
				
				
				
				System.out.println("Department: ");
				String department = scan7.nextLine();
				
				
				//Faculty faculty = new Faculty(name, id, rank, department);
				
				list.add(new Faculty(name, id, rank, department));
				listNum++;
				
			}else if (input == 2) {
				System.out.println("Name of student: ");
				String name = scan5.nextLine();
				
				System.out.println("ID: ");
				String id = null;
				
				boolean barf = false;
				
				while(barf == false) {
					int check = 0;
					try {
						
						id = scan3.nextLine();
						
						// function to search list for similar ids
						
						int value = list.checkDupId(id);
						if (value == 0) {
							break;
						}
						
						
						
						
						
						
						
						
						char[] id2 = id.toCharArray();
						for(int index = 0; index<6; index++) {
							if(index<2) {
								if((id2[index] >= 'a' && id2[index] <= 'z') || (id2[index] >= 'A' && id2[index] <= 'Z')) {
									check++;
									//System.out.println("letter check amt " +check);
								}
								
							}else {
								if(id2[index] >= '0' && id2[index] <= '9') {
									check++;
									//System.out.println("number check amt " +check);
								}
							}
						}
						//System.out.println("final check amt " + check);
						if(check == 6) {
							break;
						}
						System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit: ");
					}catch(Exception e) {
						System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit: ");
					}
				}
				
				
				
				
				System.out.println("GPA: ");
				double gpa = dataScan.nextDouble();
				
				System.out.println("Credit Hours: ");
				int creditHours = dataScan.nextInt();
				
				
				
				list.add(new Student(name, id, gpa, creditHours));
				listNum++;
				
			}
			else if (input == 3) {
				System.out.println("Enter the student's ID:  ");
				String Id = scan3.nextLine();
				
				list.printInvoice(Id);
				
				
				
		
			}
			else if (input == 4) {
				System.out.println("Enter the Faculty's ID:  ");
				String Id = scan8.nextLine();
				
				list.printFaculty(Id);
				
				
				
			}
			else if (input == 5) {
				
				System.out.println("Name of staff: ");
				String name = scan9.nextLine();
				
				System.out.println("ID: ");
				String id = scan6.nextLine();
				
				
				System.out.println("Department: ");
				String department = scan5.nextLine();
				
				System.out.println("Status: ");
				String status = scan10.nextLine();
				
				
								
				list.add(new Staff(name, id, status, department));
				listNum++;
			}
			else if (input == 6) {
				System.out.println("Enter the staff's ID:  ");
				String Id = scan3.nextLine();
				
				list.printStaff(Id);
				
			
			}
			else if (input == 7) {
				System.out.println("Enter the id of the person to delete: ");

				String inputID = scan3.nextLine();
				list.delete(inputID);
				
				
			}else {
				if(input != 8) {
					System.out.println("Invalid entry- please try again");
				}
			}
			
			
			
			
		}
		
		System.out.println("Would you like to create the report? (Y/N) : ");
		/*
		String ans = myScan.nextLine();
		
		if (ans.compareToIgnoreCase("y") == 0) {
			System.out.println("Would you like to sort students by descending gpa or name? (1 for gpa, 2 for name) : ");
			String sortOption = scan3.nextLine();

			if(sortOption.compareToIgnoreCase("1") == 0) {
				
			}
			
			// add sort and read
			
			
			try {
				PrintWriter ReportOutput = new PrintWriter("report.txt");
				ReportOutput.println("\n\nOnline Lectures");

			} catch (Exception e) {
				
			}
			
			
			System.out.println("Report created and saved on your hardrive!");
		}
		
		
		System.out.println("Goodbye!");
		*/
		String ans = myScan.nextLine();
		
		if (ans.compareToIgnoreCase("y") == 0) {
			System.out.println("Would you like to sort students by descending gpa or name? (1 for gpa, 2 for name) : ");
			String sortOption = myScan.nextLine();

			if(sortOption.compareToIgnoreCase("1") == 0) {
				ReportOutput.println("\t"+ dateFormatter.format(date)+"\t");
				ReportOutput.println("\t***********************\t\n");
				
				
				
				list.sortByType();
				list.sortByGpa();
				
				list.outputReport(ReportOutput);
			
				
			}
			else if(sortOption.compareToIgnoreCase("2") == 0) {
				ReportOutput.println("\t"+ dateFormatter.format(date)+"\t");
				ReportOutput.println("\t***********************\t\n");
				
				
				
				list.sortByType();
				list.sortByName();
				
				list.outputReport(ReportOutput);
			}
				
			// add sort and read
//			try {
//
//				
//			} catch (Exception e) {
//				
//			}
			
			
			System.out.println("Report created and saved on your hardrive!");
		}
		
		
		System.out.println("Goodbye!");
		
		
		
		
		
		
		
		
		
		
		myScan.close();
		dataScan.close();
		scan3.close();
		scan4.close();
		scan5.close();
		scan6.close();
		
		
		
		
		
		System.out.println("PROGRAM TERMINATED");
	}

     }

class compare implements Comparable<PersonList>  {



	@Override
	public int compareTo(PersonList o) {
		// TODO Auto-generated method stub
		return 0;
}

	
   }
abstract class Person{
	private String fullName;
	private String id;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public abstract void print();
}
//---------------------------
class Student extends Person{
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	private double gpa;
	private int creditHours;
	
	public Student(String name, String id, double gpa, int creditHours) {
		setFullName(name);
		setId(id);
		setGpa(gpa);
		setCreditHours(creditHours);;
		
		
	}
	
	public void print() {
		System.out.println("------------------------------------------------------");
		System.out.println(getFullName() + "\t\t\t" + getId() + "\n");
		System.out.println("Credit Hours: " + getCreditHours()+ "\t($236.45/credit hour)");
		System.out.println("Fees: $52");
		double total = (getCreditHours() * 236.45) + 52;
		double total2= total;
		if(this.gpa >= 3.85) {
			total = total * 0.75;
			
		}
		total2 -= total;
		
		System.out.println("Total Payment (after discount : " + (String.format("%.2f",total)) + "\t(" + (String.format("%.2f",total2)) + ") discount applied" );
		System.out.println("------------------------------------------------------");
		
	}
	
	
	
	
	
	
	
	
}       
 //---------------------------
    
    class Employee extends Person{
    	
    	private String department;
    
    	public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		

		@Override
		public void print() {
			
		}

    }
    

//---------------------------
    class Faculty extends Employee{
    	public Faculty(String name, String id, String rank2, String department) {
    		setFullName(name);
    		setId(id);
    		setDepartment(department);
    		setRank(rank2);

    	}

		public String getRank() {
			return Rank;
		}

		public void setRank(String rank) {
			Rank = rank;
		}

		private String Rank;
		
		@Override
		public void print() {
			System.out.println("------------------------------------------------------");
			System.out.println(getFullName() + "       " + getId() + "\n");
			System.out.println(getDepartment() +" Department, " + getRank());
	
			
			System.out.println("------------------------------------------------------");
			
		}
    	
	
   }
    
    class Staff extends Employee{
    	public Staff(String name, String id, String status2, String department) {
    		setFullName(name);
    		setId(id);
    		setDepartment(department);
    		setStatus(status2);
    		
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		@Override
		public void print() {
			
			System.out.println("------------------------------------------------------");
			System.out.println(getFullName() + "       " + getId() + "\n");
			System.out.println(getDepartment() +" Department " + getStatus());
	
			
			System.out.println("------------------------------------------------------");
			
			
			
		}

		String status;
    	
   }
    class PersonList {
    	private Person[] list;
    	public PersonList() {
    		list = new Person[100];
    		
    	}
    	public void add(Person e) {
    		boolean full = true;
    		for (int index = 0; index < 100; index++) {
    			if (list[index] == null) {
    				list[index] = e;
    				if(list[index] instanceof Student) {
    					System.out.println("Student added!");
    				}
    				else if(list[index] instanceof Faculty) {
    					System.out.println("Faculty added!");
    				}
    				else if(list[index] instanceof Staff) {
    					System.out.println("Staff added!");
    				}
    				
    				full = false;
    				break;
    			}
    		}
    		if (full)
    			System.out.println("Sorry Book is not allowed at this time...");

    	}
    	public void delete(String Id) {
    		int index = searchById(Id);

    		if (index != -1) {
    			list[index] = null;
    			System.out.print("Person delted!");
    		}else {
    			System.out.println("Sorry no such person exists");
    		}
    		

    	}
    	
    	private int searchById(String Id) {
    		int index = 0;
    		for (index = 0; index < 100; index++) {
    			if (list[index] != null && Id.compareToIgnoreCase(list[index].getId()) == 0)
    				return index;
    		}
    		return -1;
    	}
    	
    	
    	
    	public void printInvoice(String Id) {
    		int index = 0;
    		boolean idk = false;
    		for (index = 0; index < 100; index++) {
    			if (list[index] != null && Id.compareToIgnoreCase(list[index].getId()) == 0) {
    				list[index].print();
    				idk = true;
    			}	
    		}
    		if(idk == false) {
    			System.out.println("No student matched!");
    		}
    	}
    	
    	public void printFaculty(String Id) {
    		int index = 0;
    		boolean idk = false;
    		for (index = 0; index < 100; index++) {
    			if (list[index] != null && Id.compareToIgnoreCase(list[index].getId()) == 0) {
    				list[index].print();
    			}	
    		}
    		if(idk == false) {
    			System.out.println("No faculty matched!");
    		}
    	}
    	
    	public void printStaff(String Id) {
    		int index = 0;
    		boolean idk = false;
    		for (index = 0; index < 100; index++) {
    			if (list[index] != null && Id.compareToIgnoreCase(list[index].getId()) == 0) {
    				list[index].print();
    			}	
    		}
    		if(idk == false) {
    			System.out.println("No staff matched!");
    		}
    	}
    	
    	public int checkDupId(String Id) {
    		int index = 0;
    		
    		for (index = 0; index < 100; index++) {
    			if (list[index] != null && Id.compareToIgnoreCase(list[index].getId()) == 0) {
    				return 0;
    			}	
    		}
    		return 1;
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//___________________________________________
    	public void sortByType () {
    		Person [] buffer = new Person [100];
    		int index = 0;
    		
    		for ( Person e : list ) {
    			if ( e instanceof Faculty  ) {
    				buffer[index++] = e;			
    			}
    		}
    		for ( Person e : list ) {
    			if ( e instanceof Staff ) {
    				buffer[index++] = e;			
    			}
    		}
    		for ( Person e : list ) {
    			if ( e instanceof Student  ) {
    				buffer[index++] = e;			
    			}
    		}
    		//_________________________________
    		
    		index = 0;
    		for ( Person e : buffer ) {
    			list[index++]= e;
    		}
    		
    	}
    	
    	public void sortByName () {
    		int studentIndex = 0;
    		int index = 0;
    		for ( index = 0; index < 100; index++ ) {
    			
    			if(list[index] instanceof Student) {
    				studentIndex = index;
    			}
    			
    			
    		}

    		
    	       Person temp;
    	        for (int i = studentIndex; i < 100; i++) {
    	            for (int j = i + 1; j < 100; j++) {
    	               
    	                // to compare one string with other strings
    	                if (list[i].getFullName().compareTo(list[j].getFullName()) < 0) {
    	                    // swapping
    	                    temp = list[i];
    	                    list[i] = list[j];
    	                    list[j] = temp;
    	                }
    	            }
    	        }
    		
    		
//    		for ( index = studentIndex; index < 100 - 1; index++ ) {
//    			if(list[index].getFullName().compareTo(list[index+1].getFullName()) == 0 ) {
//    				Person e = list[index];
//    			}
//    			
//    		}
//    		
    		
    		
    		

    	}
    	
    	public void sortByGpa () {
    		int studentIndex = 0;
    		int index = 0;
    		
    		for ( index = 0; index < 100; index++ ) {
    			
    			if(list[index] instanceof Student) {
    				studentIndex = index;
    			}
    			
    			
    		}
    		
    		Person temp;
	        for (int i = studentIndex; i < 99; i++) {
	            for (int j = i + 1; j < 99; j++) {
	               
	                // to compare one string with other strings
	                if (((Student) list[i]).getGpa() > ((Student) list[j]).getGpa()) {
	                    // swapping
	                    temp = list[i];
	                    list[i] = list[j];
	                    list[j] = temp;
	                }
	            }
	        }

    		
    	}
    	
    	public void outputReport(PrintWriter ReportOutput) {
    		int numberCount = 0; 
    		 
    		for (int index = 0; index < 100; index++ )
    			if (list[index] instanceof Faculty) {
        			numberCount++;
    				ReportOutput.println("Faculty Members");
    				ReportOutput.println("-------------------------");
    				ReportOutput.println("\t " +numberCount + "." + list[index].getFullName());
    				ReportOutput.println("\t " +"ID:" + "." + list[index].getFullName());
    				ReportOutput.println(((Faculty) list[index]).getDepartment() + ", " + ((Faculty)list[index]).getRank());

    			}
    		
    		numberCount = 0;
    		
    		for (int index = 0; index < 100; index++)
    			if (list[index] instanceof Staff) {
        			numberCount++;
    				ReportOutput.println("Staff Members");
    				ReportOutput.println("-------------------------");
    				ReportOutput.println("\t " +numberCount + "." + list[index].getFullName());
    				ReportOutput.println("\t " +"ID:" + "." + list[index].getFullName());
    				ReportOutput.println(((Staff) list[index]).getDepartment() + ", " + ((Staff) list[index]).getStatus());


    			}
    		
    		numberCount = 0;

    		for (int index = 0; index < 100; index++)
    			if (list[index] instanceof Student) {
        			numberCount++;
    				ReportOutput.println("Students");
    				ReportOutput.println("-------------------------");
    				ReportOutput.println("\t " +numberCount + "." + list[index].getFullName());
    				ReportOutput.println("\t " +"ID:" + "." + list[index].getFullName());
    				ReportOutput.println( "\t Gpa: " + ((Student) list[index]).getGpa());
    				ReportOutput.println( "\t Credit hours: " + ((Student) list[index]).getGpa());
    				

    			}

    	}

    	
    
    }

    
