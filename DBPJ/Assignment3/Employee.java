class Employee{
	
	private int empID;
	private String empName;
	private String empDesignation;
	private double empSalary;

	//default constructor
	Employee(){

	}

	Employee(int id, String name, String designation, double salary){
		this.empID = id;
		this.empName = name;
		this.empDesignation = designation;
		this.empSalary = salary;
	}

	//method for displaying all the employee details
	public void displayEmployeeDetails(){
		System.out.println("Employee ID:" + this.empID);
		System.out.println("Employee Name:" + this.empName);
		System.out.println("Employee Designation:" + this.empDesignation);
		System.out.println("Employee Salary:" + this.empSalary);
	}

	//search employee
	public static int searchEmployeeById(Employee[] emp, int id){
		for(int i = 0; i <  emp.length; i++)
		{
			if(emp[i].empID == id)
				return i; 
		}
		return -1;
	}

	//hike salary by 10%
	public double salaryHike(double number){
		return this.empSalary = this.empSalary * (1 + (number/100));
	}

	public Boolean isIDEqual(int ID) {
        if (this.empID == ID) {
            return true;
        }
        return false;
    }

}