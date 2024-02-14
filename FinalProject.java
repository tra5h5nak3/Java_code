/*
-	Final Project 
-	Bryce Kelly, Pavan Tamma
*/

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FinalProject {

	public static void main(String[] args) throws FileNotFoundException {
		PersonList list = new PersonList();
		int listNum = 0;
		PrintWriter ReportOutput = new PrintWriter("report.txt");
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date(System.currentTimeMillis());

		Scanner myScan = new Scanner(System.in);
		Scanner dataScan = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);

		int input = 0;
		System.out.println("Choose one of the options:");

		while (input != 8) {
			System.out.println("1- Enter the information of a faculty\n" + "2- Enter the information of a student\n"
					+ "3- Print tuition invoice for a student\n" + "4- Print faculty information\n"
					+ "5- Enter the information of a staff member\n" + "6- Print the information of a staff member\n"
					+ "7- Delete a Person\n" + "8- Exit Program\n");

			System.out.println("Enter your selection: ");

			scan4.reset();
			scan3.reset();
			dataScan.reset();
			myScan.reset();
			input = 10;
			try {
				input = scan4.nextInt();
				scan4.nextLine();

			} catch (Exception e) {

				String input2 = scan4.nextLine();
				System.out.print("\n");

			}

			if (input == 1) {

				System.out.println("Name of faculty: ");
				String name = dataScan.nextLine();

				System.out.println("ID: ");
				String id = null;

				boolean barf = false;

				while (barf == false) {
					int check = 0;
					try {

						id = scan3.nextLine();

						// function to search list for similar ids

						int value = list.checkDupId(id);
						if (value == 0) {
							break;
						}

						char[] id2 = id.toCharArray();
						for (int index = 0; index < 6; index++) {
							if (index < 2) {
								if ((id2[index] >= 'a' && id2[index] <= 'z')
										|| (id2[index] >= 'A' && id2[index] <= 'Z')) {
									check++;
									// System.out.println("letter check amt " +check);
								}

							} else {
								if (id2[index] >= '0' && id2[index] <= '9') {
									check++;
									// System.out.println("number check amt " +check);
								}
							}
						}
						// System.out.println("final check amt " + check);
						if (check == 6) {
							break;
						}
						System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit: ");
					} catch (Exception e) {
						System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit: ");
					}
				}

				boolean boof = false;
				String rank = null;
				while (boof == false) {
					System.out.println("Rank: ");
					rank = dataScan.nextLine();
					try {
						if ((rank.compareToIgnoreCase("professor") == 0)
								|| (rank.compareToIgnoreCase("adjunct") == 0)) {
							break;
						}
						System.out.println("'" + rank + "' is invalid");

					} catch (Exception e) {
						System.out.println("'" + rank + "' is invalid");
					}

				}

				boof = false;
				String department = null;
				while (boof == false) {
					System.out.println("Department: ");
					department = dataScan.nextLine();
					try {
						if ((department.compareToIgnoreCase("English") == 0)
								|| (department.compareToIgnoreCase("Mathematics") == 0)
								|| (department.compareToIgnoreCase("Engineering") == 0)) {
							break;
						}
						System.out.println("'" + department + "' is invalid");

					} catch (Exception e) {
						System.out.println("'" + department + "' is invalid");
					}

				}

//				System.out.println("Department: ");
//				String department = dataScan.nextLine();

				// Faculty faculty = new Faculty(name, id, rank, department);

				list.add(new Faculty(name, id, rank, department));
				listNum++;

			} else if (input == 2) {
				System.out.println("Name of student: ");
				String name = scan3.nextLine();

				System.out.println("ID: ");
				String id = null;

				boolean barf = false;

				while (barf == false) {
					int check = 0;
					try {

						id = scan3.nextLine();

						// function to search list for similar ids

						int value = list.checkDupId(id);
						if (value == 0) {
							break;
						}

						char[] id2 = id.toCharArray();
						for (int index = 0; index < 6; index++) {
							if (index < 2) {
								if ((id2[index] >= 'a' && id2[index] <= 'z')
										|| (id2[index] >= 'A' && id2[index] <= 'Z')) {
									check++;
									// System.out.println("letter check amt " +check);
								}

							} else {
								if (id2[index] >= '0' && id2[index] <= '9') {
									check++;
									// System.out.println("number check amt " +check);
								}
							}
						}
						// System.out.println("final check amt " + check);
						if (check == 6) {
							break;
						}
						System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit: ");
					} catch (Exception e) {
						System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit: ");
					}
				}

				double gpa = 0;
				boolean boof = false;
				while (boof == false) {
					try {
						System.out.println("GPA: ");
						gpa = dataScan.nextDouble();
						boof = true;

					} catch (Exception e) {
						String invalid = dataScan.nextLine();
						System.out.println("'" + invalid + "' is invalid");
					}

				}

				int creditHours = 0;
				boof = false;
				while (boof == false) {
					try {
						System.out.println("Credit Hours: ");

						creditHours = dataScan.nextInt();
						boof = true;

					} catch (Exception e) {
						String invalid = dataScan.nextLine();
						System.out.println("'" + invalid + "' is invalid");
					}

				}

				dataScan.nextLine();

				list.add(new Student(name, id, gpa, creditHours));
				listNum++;

			} else if (input == 3) {
				System.out.println("Enter the student's ID:  ");
				String Id = scan3.nextLine();

				list.printInvoice(Id);

			} else if (input == 4) {
				System.out.println("Enter the Faculty's ID:  ");
				String Id = dataScan.nextLine();

				list.printFaculty(Id);

			} else if (input == 5) {

				System.out.println("Name of staff: ");
				String name = dataScan.nextLine();

				System.out.println("ID: ");
				String id = null;

				boolean barf = false;

				while (barf == false) {
					int check = 0;
					try {

						id = scan3.nextLine();

						// function to search list for similar ids

						int value = list.checkDupId(id);
						if (value == 0) {
							System.out.println("Invalid ID format. Must be Not Be Duplicate: ");
							break;

						}

						char[] id2 = id.toCharArray();
						for (int index = 0; index < 6; index++) {
							if (index < 2) {
								if ((id2[index] >= 'a' && id2[index] <= 'z')
										|| (id2[index] >= 'A' && id2[index] <= 'Z')) {
									check++;
									// System.out.println("letter check amt " +check);
								}

							} else {
								if (id2[index] >= '0' && id2[index] <= '9') {
									check++;
									// System.out.println("number check amt " +check);
								}
							}
						}
						// System.out.println("final check amt " + check);
						if (check == 6) {
							break;
						}
						System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit: ");
					} catch (Exception e) {
						System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit: ");
					}
				}

				boolean boof = false;
				String department = null;
				while (boof == false) {
					System.out.println("Department: ");
					department = dataScan.nextLine();
					try {
						if ((department.compareToIgnoreCase("English") == 0)
								|| (department.compareToIgnoreCase("Mathematics") == 0)
								|| (department.compareToIgnoreCase("Engineering") == 0)) {
							break;
						}
						System.out.println("'" + department + "' is invalid");

					} catch (Exception e) {
						System.out.println("'" + department + "' is invalid");
					}

				}

				boof = false;
				String status = null;
				while (boof == false) {
					System.out.println("Status, Enter P for Part Time, or Enter F for Full Time: ");
					status = dataScan.nextLine();
					try {
						if (status.compareToIgnoreCase("f") == 0) {
							status = "Full Time";
							boof = true;

						} else if (status.compareToIgnoreCase("p") == 0) {
							status = "Part Time";
							boof = true;

						} else
							System.out.println("'" + status + "' is invalid");

					} catch (Exception e) {
						System.out.println("'" + status + "' is invalid");
					}

				}

				list.add(new Staff(name, id, status, department));
				listNum++;
			} else if (input == 6) {
				System.out.println("Enter the staff's ID:  ");
				String Id = scan3.nextLine();

				list.printStaff(Id);

			} else if (input == 7) {
				System.out.println("Enter the id of the person to delete: ");

				String inputID = scan3.nextLine();
				list.delete(inputID);

			} else if (input == 8) {

			} else {
				System.out.println("Invalid entry- please try again");
			}

		}

		System.out.println("Would you like to create the report? (Y/N) : ");

		String ans = myScan.nextLine();

		boolean boof = false;
		while (boof == false) {
			try {
				if (ans.compareToIgnoreCase("y") == 0) {
					System.out.println(
							"Would you like to sort students by descending gpa or name? (1 for gpa, 2 for name) : ");
					String sortOption = myScan.nextLine();

					if (sortOption.compareToIgnoreCase("1") == 0) {
						ReportOutput.println("\t" + dateFormatter.format(date) + "\t");
						ReportOutput.println("\t***********************\t\n");

						list.sortByType();
						list.sortByGpa();

						list.outputReport(ReportOutput);
						System.out.println("Report created and saved on your hardrive!");

						boof = true;

					} else if (sortOption.compareToIgnoreCase("2") == 0) {
						ReportOutput.println("\t" + dateFormatter.format(date) + "\t");
						ReportOutput.println("\t***********************\t\n");

						list.sortByType();
						list.sortByName();

						list.outputReport(ReportOutput);
						System.out.println("Report created and saved on your hardrive!");
						boof = true;

					} else {
						System.out.println("Invalid Option try again\n");

					}

				}
			} catch (Exception E) {
				System.out.println("Invalid Option try again");
			}
		}

		System.out.println("Goodbye!");
		System.out.print("______________________________________________________________");

		myScan.close();
		dataScan.close();
		scan3.close();
		scan4.close();
		ReportOutput.close();

	}

}

abstract class Person {
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
class Student extends Person {

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

	public Student() {
	}

	public Student(String name, String id, double gpa, int creditHours) {
		setFullName(name);
		setId(id);
		setGpa(gpa);
		setCreditHours(creditHours);
		;

	}

	public void print() {
		System.out.println("------------------------------------------------------");
		System.out.println(getFullName() + "       " + getId() + "\n");
		System.out.println("Credit Hours: " + getCreditHours() + "  ($236.45/credit hour)");
		System.out.println("Fees: $52");
		double total = (getCreditHours() * 236.45) + 52;
		double total2 = total;
		if (this.gpa >= 3.85) {
			total = total * 0.75;

		}
		total2 -= total;

		System.out.println("Total Payment (after discount : " + (String.format("%.2f", total)) + "\t("
				+ (String.format("%.2f", total2)) + ") discount applied");
		System.out.println("------------------------------------------------------");

	}

}
// ---------------------------

class Employee extends Person {
	public Employee() {
	}

	public Employee(int i) {
	}

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
class Faculty extends Employee {
	public Faculty() {
	}

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
		System.out.println(getDepartment() + " Department, " + getRank());

		System.out.println("------------------------------------------------------");

	}

}

class Staff extends Employee {
	public Staff() {
	}

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
		System.out.println(getDepartment() + " Department " + getStatus());

		System.out.println("------------------------------------------------------");

	}

	String status;

}

class PersonList {
	private Person[] list;

	public PersonList() {
		list = new Person[100];

	}

	public PersonList(int i) {
		list = new Person[i];

	}

	public void add(Person e) {
		boolean full = true;
		for (int index = 0; index < 100; index++) {
			if (list[index] == null) {
				list[index] = e;
				if (list[index] instanceof Student) {
					System.out.println("Student added!");
				} else if (list[index] instanceof Faculty) {
					System.out.println("Faculty added!");
				} else if (list[index] instanceof Staff) {
					System.out.println("Staff member added!");
				}

				full = false;
				break;
			}
		}
		if (full)
			System.out.println("Sorry this is not allowed at this time...");

	}

	public void delete(String Id) {
		int index = searchById(Id);

		if (index != -1) {
			list[index] = null;
			System.out.println("Person deleted!");
		} else {
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
		if (idk == false) {
			System.out.println("No student matched!");
		}
	}

	public void printFaculty(String Id) {
		int index = 0;
		boolean idk = false;
		for (index = 0; index < 100; index++) {
			if (list[index] != null && Id.compareToIgnoreCase(list[index].getId()) == 0) {
				list[index].print();
				idk = true;
			}
		}
		if (idk == false) {
			System.out.println("No faculty matched!");
		}
	}

	public void printStaff(String Id) {
		int index = 0;
		boolean idk = false;
		for (index = 0; index < 100; index++) {
			if (list[index] != null && Id.compareToIgnoreCase(list[index].getId()) == 0) {
				list[index].print();
				idk = true;
			}
		}
		if (idk == false) {
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

	// ___________________________________________
	public void sortByType() {
		Person[] buffer = new Person[100];
		int index = 0;

		for (Person e : list) {
			if (e instanceof Faculty) {
				buffer[index++] = e;
			}
		}
		for (Person e : list) {
			if (e instanceof Staff) {
				buffer[index++] = e;
			}
		}
		for (Person e : list) {
			if (e instanceof Student) {
				buffer[index++] = e;
			}
		}
		// _________________________________

		index = 0;
		for (Person e : buffer) {
			list[index++] = e;
		}

	}

	public void sortByName() {
		int studentIndex = 0;
		int index = 0;

		for (index = 0; index < 100; index++) {

			if (list[index] instanceof Staff) {
				studentIndex = index;
			}

		}

		Student temp;
		for (int i = studentIndex; i < 100; i++) {
			for (int j = i + 1; j < 100; j++) {
				try {
					// to compare one string with other strings

					if (((Student) list[i]).getFullName().compareToIgnoreCase(((Student) list[j]).getFullName()) < 0) {
						// swapping
						temp = (Student) list[i];
						list[i] = (Student) list[j];
						list[j] = temp;
					}

				} catch (Exception e) {
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

	public void sortByGpa() {
		int studentIndex = 0;

		int index = 0;

		for (index = 0; index < 100; index++) {
			if (list[index] instanceof Staff) {
				studentIndex = index;
			}

		}

		Student temp;
		for (int i = studentIndex; i < 100; i++) {
			for (int j = i + 1; j < 100; j++) {

				// to compare gpa with other gpa
				try {
					if (((Student) list[i]).getGpa() < ((Student) list[j]).getGpa()) {
						temp = (Student) list[i];
						list[i] = (Student) list[j];
						list[j] = temp;
					}

				} catch (Exception e) {

				}

			}
		}

	}

	public void outputReport(PrintWriter ReportOutput) {
		int numberCount = 0;
		ReportOutput.println("Faculty Members");
		ReportOutput.println("-------------------------");

		for (int index = 0; index < 100; index++)
			if (list[index] instanceof Faculty) {
				numberCount++;

				ReportOutput.println("\t " + numberCount + "." + list[index].getFullName());
				ReportOutput.println("\t " + "ID:" + list[index].getId());
				ReportOutput.println(
						"\t " + ((Faculty) list[index]).getDepartment() + ", " + ((Faculty) list[index]).getRank());
				ReportOutput.println();

			}

		numberCount = 0;

		ReportOutput.println("Staff Members");
		ReportOutput.println("-------------------");

		for (int index = 0; index < 100; index++)
			if (list[index] instanceof Staff) {
				numberCount++;

				ReportOutput.println("\t " + numberCount + "." + list[index].getFullName());
				ReportOutput.println("\t " + "ID:" + list[index].getId());
				ReportOutput.println(
						"\t " + ((Staff) list[index]).getDepartment() + ", " + ((Staff) list[index]).getStatus());
				ReportOutput.println();

			}

		numberCount = 0;

		ReportOutput.println("Students");
		ReportOutput.println("-----------");

		for (int index = 0; index < 100; index++)
			if (list[index] instanceof Student) {
				numberCount++;

				ReportOutput.println("\t " + numberCount + "." + list[index].getFullName());
				ReportOutput.println("\t " + "ID:" + list[index].getId());
				ReportOutput.println("\t Gpa: " + ((Student) list[index]).getGpa());
				ReportOutput.println("\t Credit hours: " + ((Student) list[index]).getCreditHours());
				ReportOutput.println();

			}

	}

}
