import java.sql.*;

class DBase{

	private Connection con;
	private Statement stm;
	public ResultSet rs;

	public int loadDriver(String driver)
	{
		try{
			Class.forName(driver);
			return 1;
		}catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	}

	public int createConnection(String database)
	{
		try{
			con = DriverManager.getConnection(database,"root","admin");
			return 1;
		}catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	}

	public int getStatement()
	{
		try{
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			return 1;
		}catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	}

	public void retrieveRecord(String sql)
	{
		try{
			rs = stm.executeQuery(sql);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void closeObject()
	{
		try{
			rs.close();
			stm.close();
			con.close();

		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}