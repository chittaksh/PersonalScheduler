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
    public int FetchMax(string tblnm, string fldnm)
    {
        int maxid = 0;
        try
        {
            scon = DBConnect.ConnectDB();
            string qr = "select max(" + fldnm + ") as mid from " + tblnm;
            SqlDataAdapter sda = new SqlDataAdapter(qr, scon);
            DataSet ds = new DataSet();
            sda.Fill(ds, "mxid");
            maxid = Convert.ToInt32(ds.Tables["mxid"].Rows[0]["mid"]);
        }

        catch (Exception)
        {
            return 1001;

        }
        finally
        {
            scon.Close();
        }
        return (maxid + 1);
    }

    public Boolean Insertion(String tblnm, ArrayList data, ArrayList col)
    {
        scon = DBConnect.ConnectDB();
        try
        {
            qr = "insert into " + tblnm + " values(@" + col[0].ToString();
            for (i = 1; i < col.Count; i++)
            {
                qr += ", @" + col[i].ToString();
            }
            qr += ")";

            scmd = new SqlCommand(qr, scon);


            for (i = 0; i < data.Count; i++)
            {
                
                    scmd.Parameters.AddWithValue(col[i].ToString(), data[i].ToString());
                 
            }
            sda = new SqlDataAdapter(scmd);
            ds = new DataSet();
            sda.Fill(ds, "usr");

            return true;
        }
        catch (Exception e1)
        {
            return false;
        }
        finally
        {
            scon.Close();
        }

    }

    public static ArrayList Authentication(string uid, string ps)
    {
        SqlDataAdapter sda;
        SqlConnection scon;
        ArrayList msg = new ArrayList();
        try
        {
            scon = DBConnect.ConnectDB();
            string pwschk = "Select * from users where userid='" + uid.Trim() + "' and pass='" + ps.Trim() + "'";
            sda = new SqlDataAdapter(pwschk, scon);
            DataSet ds = new DataSet();
            sda.Fill(ds, "chkpw");
            if (ds.Tables["chkpw"].Rows.Count > 0)
            {
                msg.Add("valid_user");
                string usrid = ds.Tables[0].Rows[0]["userid"].ToString();

               
                msg.Add(usrid);
          
            }
            else
                msg.Add("invalid_user");
        }
        catch (Exception e)
        {
            msg.Clear();
            msg.Add(e.Message.ToString());

        }

        return (msg);
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

    public ArrayList ExecuteQuery(string qr, int cols)
    {
        ArrayList alst = new ArrayList();
        alst.Clear();
        try
        {
            scon = DBConnect.ConnectDB();
            SqlDataAdapter sda = new SqlDataAdapter(qr, scon);
            DataSet ds = new DataSet();
            sda.Fill(ds, "arr");
            int n = ds.Tables["arr"].Rows.Count;
            for (i = 0; i < n; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    alst.Add(ds.Tables["arr"].Rows[i][j]);
                }
            }
        }

        catch (Exception e1)
        { alst.Add(e1.Message.ToString()); }
        return alst;
    }


}