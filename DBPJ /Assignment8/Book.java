import java.util.Scanner;

public class Book
{
	
	private DBase db = null;
	private Scanner sc = new Scanner(System.in);
	
	Book(){
	getRecord();
	int choice;
	try{
		// ***Book info*****
	
	do{
		System.out.println("Menu:");
		System.out.println("1. First");
		System.out.println("2. Last");
		System.out.println("3. Next");
		System.out.println("4. Previous");
		System.out.println("5. Search");
		System.out.println("6. Exit");

		System.out.println("Enter your choice");
		choice = sc.nextInt();

		switch(choice)
		{
			case 1:
				db.rs.first();
				System.out.println(db.rs.getInt(1));
				System.out.println(db.rs.getString(2));
				System.out.println(db.rs.getDouble(3));

				break;
			case 2:
				db.rs.last();
				System.out.println(db.rs.getInt(1));
				System.out.println(db.rs.getString(2));
				System.out.println(db.rs.getDouble(3));
				break;

			case 3:
				if(db.rs.isLast())
				{
					System.out.println("Last record.......");
				}else{
					db.rs.next();
					System.out.println(db.rs.getInt(1));
					System.out.println(db.rs.getString(2));
					System.out.println(db.rs.getDouble(3));				
				}
				break;
			case 4:
				if(db.rs.isFirst())
				{
					System.out.println("First record.......");
				}else{
					db.rs.previous();
					System.out.println(db.rs.getInt(1));
					System.out.println(db.rs.getString(2));
					System.out.println(db.rs.getDouble(3));				
				}
				break;
			case 5:
				try{
					System.out.println("Enter book id: ");
					int id = sc.nextInt();
					db.searchRecord(id);

					db.rs1.next();
					System.out.println(db.rs1.getInt(1));
					System.out.println(db.rs1.getString(2));
					System.out.println(db.rs1.getDouble(3));	

				}catch(Exception e)
				{
					System.out.println(e);
				}
				break;
		}

		}while(choice !=6);
	}catch(Exception e)
	{
		System.out.println(e);
	}
	db.closeObject();
	System.out.println("Thank you for using Bookinfo App....");

}

public void getRecord()
	{
		db = new DBase();

		String drivername = "com.mysql.jdbc.Driver";
		String databasename = "jdbc:mysql://localhost:3306/mydb";

		if(db.loadDriver(drivername) == 1)
		{
			System.out.println("Successfully loaded driver....");
		}

		if(db.createConnection(databasename) == 1)
		{
			System.out.println("Successfully connected database.....");
		}

		String sql = "select * from book where bookid=?";
		if(db.getPrepareStatement(sql) == 1){
			System.out.println("Successfully created prepared statement object......");
		}

		if(db.getStatement() == 1)
		{
			System.out.println("Successfully created statement object....");
		}

		sql = "select * from book";
			System.out.println("before");
			db.retrieveRecord(sql);
			System.out.println("after");
			
	}

	public static void main(String[] args) {
		new Book();
	}
}