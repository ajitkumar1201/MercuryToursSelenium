package pkgGenericLib;


import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.net.InetAddress;
import java.util.Hashtable;

public class DatabaseFunction
{
    public static Connection con;
    public static Statement st;
    public static ResultSet res;
    public static String computerName,sql,Path;
    public static int projectVersionID,projectID,runID,testSuiteID,testCaseID,testDataID;
    public String sqlQuery;
    public static String fileType;
    
    public String genericPath=System.getProperty("user.dir").concat("\\src\\test\\resources\\TestData\\");
    public DatabaseFunction()
    {
    	 
        //Connecting with Database
    try
    {
        computerName = InetAddress.getLocalHost().getHostName();
        Path=System.getProperty("user.dir");
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        System.out.println("Database connected Successfully.");
        


    }
    catch (Exception exc)
    {
        System.out.println("DBConnection Failed"+exc);
        
    }
  }
    //##################################################################################################################################
    public Connection fnGetDbConnection(String FileType)
    {   
    	
    	try
    	{
	    	if("Input".equals(FileType))
	    	   
	    	{
	    		con = DriverManager.getConnection( "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + genericPath);
	    	}
	    	/*if("ObjectRepository".equals(FileType))
		    	   
	    	{
	    		con = DriverManager.getConnection( "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=C:\\work_b\\POC\\src\\main\\resources\\ObjectRepository1.xls");
	    	}
	    	if("Scenario".equals(FileType))
		    	   
	    	{
	    		con = DriverManager.getConnection( "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=C:\\work_b\\POC\\src\\main\\resources\\Scenario.xls");
	    	}
	    	if("Result".equals(FileType))
		    	   
	    	{
	    		con = DriverManager.getConnection( "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=C:\\work_b\\POC\\src\\main\\resources\\Result.xls");
	    	}*/
	    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        
	         st=con.createStatement();

	         System.out.println("Database connected Successfully.");
	       
    	}
    	catch(Exception exc)
    	{
    		System.out.println("fnGetDbConnectionDBConnection Failed"+exc);
    	}
    	
    	return con;
    }
    //##########################################################################################################################################

    // <summary>
    // Function to execute Sql Qry
    // </summary>
    // <param name="sqlquery">SqlQuery</param>
    // <returns>Records</returns>

public char fnExecuteSql(String sqlQuery,String FileType)
{
	 String s;
	 char val = 0;
try
{
	fnGetDbConnection(FileType);
    st = con.createStatement();
   
    res = st.executeQuery(sqlQuery);
    ResultSetMetaData rsmd = res.getMetaData();
    int numberOfColumns = rsmd.getColumnCount();
    int Row=res.getRow();
    res.getStatement();
    
    while(res.next())
    {
    	
    	 s=res.getString(1);
    	val=s.charAt(0);
    	 
    }
 
   
}
catch (Exception SQLException)
{       
   System.out.print("Exception in fnExecuteSql:"+SQLException);
    
}
return val;

}
//##########################################################################################################################################


//##########################################################################################################################################

// <summary>
// Function to get the object details from database for the specified screen name.
// </summary>
// <param name="screenName">Screen Name</param>
// <returns>True if Screen Name exists in database else returns false.</returns>

	public Hashtable<String,String> getObject(String sqlQuery,String FileType)
	{
		Hashtable<String,String> htbl = new Hashtable<String,String>();
		
	try
	{
		fnGetDbConnection(FileType);
	    st = con.createStatement();
	    res = st.executeQuery(sqlQuery);
	    
	    while (res.next())
	    {
	    	
	    	String objectName = res.getString("objName");
	    	String objectProperties= res.getString("objId");
	    	htbl.put(objectName, objectProperties);
	      
	       
	    }
	}
	catch (Exception exc)
	{       
	  System.out.println(exc);
	}
	return htbl;
	}
//#####################################################################################################################   

	 // <summary>
    // Function to get the object details from database for the specified screen name.
    // </summary>
    // <param name="screenName">Screen Name</param>
    // <returns>True if Screen Name exists in database else returns false.</returns>

		public Hashtable<String,String> getInput(String sqlQuery,String SheetName,String colName)
		{
			Hashtable<String,String> htbl = new Hashtable<String,String>();
			
		try
		{
			fnGetDbConnection(SheetName);
		    st = con.createStatement();
		    res = st.executeQuery(sqlQuery);
		    
		    while (res.next())
		    {
		    	
		    	String objectName = res.getString(colName);
		    	//String objectProperties= res.getString("objId");
		    	htbl.put(colName, objectName);			      
		       
		    }
		}
		catch (Exception exc)
		{       
		  System.out.println(exc);
		}
		return htbl;
		}
}
