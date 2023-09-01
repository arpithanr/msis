import java.util.*;

public class TestEIS{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of employees:");
		int size = sc.nextInt();

		Employee emp[] = new Employee[size];

		for(int i = 0; i < emp.length; i++){
			System.out.println("Enter Employee Id:");
			int empId = sc.nextInt();
			System.out.println("Enter Employee Name:");
			String empName = sc.next();
			System.out.println("Enter Employee Designation:");
			String empDesignation = sc.next();
			System.out.println("Enter Employee Salary:");
			double empSalary = sc.nextDouble();

			emp[i] = new Employee(empId, empName, empDesignation, empSalary);
		}

		for(int i = 0; i < emp.length; i++)
		{
			System.out.println("Employee" + (i+1) + "Details:");
			emp[i].displayEmployeeDetails();
		}

		int choice;
		do{
			System.out.println("Enter the choice which you want to select");
			System.out.println("1. Search Employee");
			System.out.println("2. Hike Salary");
			System.out.println("3. Display employee details by id");
			System.out.println("4. Display all employees");
			System.out.println("5. Exit");
			choice = sc.nextInt();

			switch(choice){
			case 1: System.out.println("Enter the Employee ID to search:");
					int searchId = sc.nextInt();
					int empId = Employee.searchEmployeeById(emp, searchId);
					if(empId >= 0){
						System.out.println("Employee with Id " + searchId + " exists.");
						emp[empId].displayEmployeeDetails();
					}
					else 
						System.out.println("Employee with Id " + searchId + " doesn't exists.");
					break;
				case 2:
					System.out.println("Enter the employee ID to hike:");
					int hikeId = sc.nextInt();
					if (Employee.searchEmployeeById(emp, hikeId) >= 0) {
						System.out.println("Enter how much percentage of hike you want to increase salary:");
						int number = sc.nextInt();
						boolean flag = false;
						for (int i = 0; i < emp.length; i++) {
							if (emp[i].isIDEqual(hikeId)) {
								System.out.println(emp[i].salaryHike(number));
								flag = true;
							}
						}
					} else
						System.out.println("Employee doesn't exist");
					break;
				case 3: System.out.println("Enter employee Id to display the employee details:");
						int tempId = sc.nextInt();
						tempId = Employee.searchEmployeeById(emp, tempId);
						if(tempId >= 0)
							emp[tempId].displayEmployeeDetails();
						else 
							System.out.println("Entered employee doesn't exists");
						break;
				case 4: System.out.println("Employees Information:");
						for(int i = 0; i<emp.length; i++){
							emp[i].displayEmployeeDetails();
						}
						break;
				case 5: System.out.println("Exiting from the application!!!!");
						break;
					default: System.out.println("Invalid Input. Please enter the valid input");
						break;
			}
		}while(choice != 5);
		
	}
	
}