import java.util.Scanner;

public class HealthCenter
{

	private DBase db = null;
	private Scanner sc = new Scanner(System.in);

	HealthCenter(){
		getRecord();

		int choice;

		try{
			do{
				System.out.println("Patient Information:.....");
				System.out.println("1. Search:");
				System.out.println("2. Exit");

				System.out.println("Enter your choice: ");
				choice = sc.nextInt();

				switch(choice){

				case 1: System.out.println("Enter the id:");
						int id = sc.nextInt();
						db.searchRecord(id);
						System.out.println(db.rs.getInt(1));
						System.out.println(db.rs.getString(2));
						System.out.println(db.rs.getInt(3));
						System.out.println(db.rs.getString(4));
						System.out.println(db.rs.getString(5));
						System.out.println(db.rs.getString(6));
						System.out.println(db.rs.getInt(7));
				}
			}while(choice != 2);

		}catch(Exception e)
		{

		}
		db.closeObject();
		System.out.println("Thank you for using the health center application......");
	}

	public void getRecord()
	{
		DBase db = new DBase();

		String driverName = "com.mysql.jdbc.Driver";
		String databaseName = "mysql:jdbc://localhost:3306/mydb";

		if(db.loadDriver(driverName) == 1)
		{
			System.out.println("Succesfully connected to the driver....");
		}

		if(db.createConnection(databaseName) == 1)
		{
			System.out.println("Succesfully connected to the database....");
		}

		String sql = "Select name from details where patient_id=?;";
		if(db.getPreparedStatement(sql) == 1)
		{
			System.out.println("Succesfully prepared statement object is created....");
		}

		if(db.getStatement()== 1)
		{
			System.out.println("Succesfully statement object is created....");
		}

		sql = "Select * from details;";
		System.out.println("Before");
		db.retrieveRecord(sql);
		System.out.println("After");
 	}

	public static void main(String[] args) {
		new HealthCenter();
	}
}