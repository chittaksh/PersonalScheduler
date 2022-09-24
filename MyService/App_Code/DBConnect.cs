using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
/// <summary>
/// Summary description for DBConnect
/// </summary>
public class DBConnect
{
	public DBConnect()
	{
		//
		// TODO: Add constructor logic here
		//
	}
    public static SqlConnection ConnectDB()
    {
     
        //SqlConnection scon = new SqlConnection("server=TEAMINDIA\\SQLEXPRESS;uid=sa;pwd=microsoft;database=studentdb");
        SqlConnection scon = new SqlConnection("server=Ashwini-PC\\SQLEXPRESS;uid=sa;pwd=microsoft;database=scheduledb");
      
        return scon;
    }

}