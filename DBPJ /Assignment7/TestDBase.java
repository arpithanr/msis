public class TestDBase{

	private DBase db = null;

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

		if(db.getStatement() == 1)
		{
			System.out.println("Successfully created statement object....");
		}

		try{
			db.retrieveRecord("select * from login");

			while(db.rs.next())
			{
				System.out.println(db.rs.getString(1) + "\t");
				System.out.println(db.rs.getString(2));
			}
		}
		catch(Exception e)
			{
				System.out.println(e);
			}
			db.closeObject();
	}

	public static void main(String[] args) {
		new TestDBase().getRecord();
	}
	
}