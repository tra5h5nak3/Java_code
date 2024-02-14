
class Company {

	private Employee[] list;

	public Company() {

		list = new Employee[100];
		for (int index = 0; index < 100; index++)
			list[index] = null;
	}

//_____________________________	
	public void hire(Employee e) {
		boolean full = true;
		for (int index = 0; index < 100; index++) {
			if (list[index] == null) {
				list[index] = e;
				full = false;
				break;
			}
		}
		if (full)
			System.out.println("Sorry hiring is not allowed at this time...");

	}
	// _____________________________

	public void printList() {

		System.out.println(" L I S T  O F  E M P L O Y E E S...");
		for (Employee e : list)
			if (e != null)
				System.out.println(e);
	}

	// ______________________________
	public void fire(String name) {
		int index = searchByName(name);

		if (index != -1)
			list[index] = null;

	}
	// ________________________

	public void printCheck(String name) {
		int index = searchByName(name);
		if (index != -1)
			list[index].printCheck();
	}

	// ______________________________
	private int searchByName(String name) {
		int index = 0;
		for (index = 0; index < 100; index++) {
			if (list[index] != null && name.compareToIgnoreCase(list[index].getName()) == 0)
				return index;
		}
		return -1;
	}

	// ____________________________________
	public void printSupervisors() {
		System.out.println(" L I S T   O F   S U P E R V I S O R S...");
		for (Employee e : list) {
			if (e instanceof Supervisor)
				System.out.println(e);
		}
	}
	
	//___________________________________________
	public void sortByType () {
		Employee [] buffer = new Employee [100];
		int index = 0;
		
		for ( Employee e : list ) {
			if ( e instanceof Supervisor ) {
				buffer[index++] = e;			
			}
		}
		for ( Employee e : list ) {
			if ( e instanceof SalaryPaid && !( e instanceof Supervisor)) {
				buffer[index++] = e;			
			}
		}
		for ( Employee e : list ) {
			if ( e instanceof HourlyPaid ) {
				buffer[index++] = e;			
			}
		}
		//_________________________________
		
		index = 0;
		for ( Employee e : buffer ) {
			list[index++]= e;
		}
		
	}

}// end of class Company
//==================================================

public class Driver {

	public static void main(String[] args) {

		
		
		Company c = new Company();
		c.hire(new SalaryPaid("Erick Johnson", 14589));

		c.hire(new HourlyPaid("Ericka Edwardsd", 12, 10));
		c.hire(new Supervisor("Eric John", 1000, 10));
		c.hire(new SalaryPaid("Kim Johnson", 6585));
		c.hire(new Supervisor("William Supervisor", 1000, 10));
		
		//c.printSupervisors();
		
		//c.printCheck("Ericka Edwardsd");
		System.out.println("Before ...");
		c.printList();
		
		c.sortByType();
		
		System.out.println("After ...");
		c.printList();

	}
	
	//_________________________________
	

}

//_____________________
abstract class Employee {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
		name = "NO NAME";
	}

	public Employee(String name) {
		this.name = name;
	}

	public String toString() {
		return "[" + name + "]";
	}

	abstract public void printCheck();

}

//______________________________
class HourlyPaid extends Employee { // HourlyPaid is a an Employee

	private int hoursWorked;
	private double wage;

	// ________________________________________

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "HP -->" + getName() + " Hours/wage: " + hoursWorked + "/" + wage;
	}

	public HourlyPaid() {
		super(); // optional
		hoursWorked = -1;
		wage = 0;

	}

	public HourlyPaid(String name, int hoursWorked, double wage) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.wage = wage;
	}

	public void printCheck() {
		System.out.println(this);
		System.out.println("Gross Pay = $" + hoursWorked * wage);
	}

}

//_____________________
class SalaryPaid extends Employee {

	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public SalaryPaid() {
		this.salary = 0;
	}

	public SalaryPaid(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	@Override
	public void printCheck() {
		System.out.println(getName());
		System.out.println("Gross Pay $" + salary);
	}

	@Override
	public String toString() {
		return "S -->" + getName() + " Salary: " + salary;
	}
}

//_______________________
class Supervisor extends SalaryPaid {

	private double bonus;

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public Supervisor() {
		bonus = 0;

	}

	public Supervisor(String name, double salary, double bonus) {
		super(name, salary);
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "SP->" + getName() + ", Salary = " + getSalary() + ", Bonus = " + bonus;
	}

	@Override
	public void printCheck() {
		super.printCheck();
		System.out.println("Bonus = " + bonus);
	}

}
