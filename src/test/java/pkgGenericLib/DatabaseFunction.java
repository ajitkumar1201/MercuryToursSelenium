package pkgGenericLib;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DatabaseFunction
{
    public static com.codoid.products.fillo.Connection con;
  
    public static String computerName,sql,Path;
    public static int projectVersionID,projectID,runID,testSuiteID,testCaseID,testDataID;
    public String sqlQuery;
    public static String fileType;
  
    Fillo fillo=new Fillo();
    
    public DatabaseFunction()
    {
    	 
	    try
	    {
	        computerName = InetAddress.getLocalHost().getHostName();
	        Path=System.getProperty("user.dir");
	        
	    }
	    catch (Exception exc)
	    {
	        System.out.println("DBConnection Failed"+exc);
	        
	    }
  }
    //##################################################################################################################################
    public Connection fnGetDbConnection(String FileType)
    {   
    	String genericPath=System.getProperty("user.dir").concat("\\src\\test\\resources\\TestData\\");
    	try
    	{
	    	if("Input".equals(FileType))
	    	   
	    	{
	    		System.out.println(genericPath + "TDMercuryTours.xls");
	    		con = fillo.getConnection(genericPath + "TDMercuryTours.xls");
	    	}
	    		    	

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

public List<String> fnExecuteSql(String sqlQuery,String FileType,String ColName)
 
{

	List<String> list = new ArrayList<String>();

     

	String colVal = null;
try
{
	fnGetDbConnection(FileType);
	
	Recordset recordset=con.executeQuery(sqlQuery);
	
	while(recordset.next())
	{
		list.add(recordset.getField(ColName));
		
		
	}

		recordset.close();
		con.close();
 
   
}
catch (Exception SQLException)
{       
   System.out.print("Exception in fnExecuteSql:"+SQLException);
    
}
return list;

}
//##########################################################################################################################################



}
