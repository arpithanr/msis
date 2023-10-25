import java.sql.*;

class DBase
{
	private Connection con;
	private Statement stm;
	private PreparedStatement pstm;
	public ResultSet rs, rs1;

	public int loadDriver(String driver)
	{
		try{
			Class.forName(driver);
			return 1;
		}catch(Exception e)
		{
			return -1;
		}
	}

	public int createConnection(String dbname)
	{
		try{
			con = DriverManager.getConnection(dbname, "arpi", "admin");
			return 1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}

	}

	public int getStatement()
	{
		try{
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stm = con.createStatement();
			return 1;
		}catch(Exception e){
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
			System.out.println("Exception:" + e);
		}
	}

	public int getPrepareStatement(String sql)
	{
		try{
			pstm = con.prepareStatement(sql);
			return 1;
		}catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	}

	public void searchRecord(int id)
	{
		try{
			pstm.setInt(1, id);
			rs1 = pstm.executeQuery();

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