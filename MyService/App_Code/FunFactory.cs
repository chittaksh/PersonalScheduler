using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
using System.Collections;
using System.Data;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Net;
using System.IO;
/// <summary>
/// Summary description for FunFactory
/// </summary>
public class FunFactory
{
    SqlConnection scon;
    SqlDataAdapter sda;
    String constr;
    DataSet ds;
    SqlCommand scmd;
    string qr = "";
    int i;

	public FunFactory()
	{
        scon = DBConnect.ConnectDB();
	}
   

    public static Boolean Authentication(string uid, string ps)
    {
        SqlDataAdapter sda;
        SqlConnection scon;
   
        try
        {
            scon = DBConnect.ConnectDB();
            string pwschk = "Select * from users where userid='" + uid.Trim() + "' and pass='" + ps.Trim() + "'";
            sda = new SqlDataAdapter(pwschk, scon);
            DataSet ds = new DataSet();
            sda.Fill(ds, "chkpw");
            if (ds.Tables["chkpw"].Rows.Count > 0)
            {
               
                return true;
            }
            else
            {
                
                return false;
            }
        }
        catch (Exception e)
        {
           
            return false;
        }

    
    }
   

    
    
    public DataSet FetchData(string qr)
    {
        DataSet ds = new DataSet();
        try
        {
            scon = DBConnect.ConnectDB();
            SqlDataAdapter sda = new SqlDataAdapter(qr, scon);
            sda.Fill(ds, "tbl");

        }
        catch (Exception ex)
        {

        }
        return ds;
    }
    public Boolean Execute(string qr)
    {
        DataSet ds = new DataSet();
        try
        {
            scon = DBConnect.ConnectDB();
            SqlDataAdapter sda = new SqlDataAdapter(qr, scon);
            sda.Fill(ds, "tbl");
            return true;

        }
        catch (Exception ex)
        {
            return false;
        }
        
    }
   



}