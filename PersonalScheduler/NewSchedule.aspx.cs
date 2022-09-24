using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Collections;
public partial class NewSchedule : System.Web.UI.Page
{

    ArrayList cols = new ArrayList();
    ArrayList data = new ArrayList();
    FunFactory ff = new FunFactory();
    DataSet ds = new DataSet();
    int value = 0;
    String msg = "";
    protected void Page_Load(object sender, EventArgs e)
    {

        if (!IsPostBack)
        {
            listtm.Items.Add("am");
            listtm.Items.Add("pm");
            for (int i = 1; i <= 12; i++)
            {
                //  if (i < 10)
                //    listhr.Items.Add("0" + i.ToString());
                //   else
                listhr.Items.Add(i.ToString());
            }
            for (int i = 0; i <= 59; i++)
            {
                //  if(i<10)
                //       listmin.Items.Add("0"+i.ToString());
                //  else
                listmin.Items.Add(i.ToString());
            }

        }
        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1));
        Response.Cache.SetCacheability(HttpCacheability.NoCache);
        Response.Cache.SetNoStore();
    }
    protected void Submit(object sender, EventArgs e)
    {
        try
        {
            data.Clear();
            String date = txtdt.Text.Trim();
            String[] str = date.Split('/');

            int maxid = ff.FetchMax("schedules", "sid");
            data.Add(maxid);
            data.Add(cmbstyp.Text.Trim());
            data.Add(str[0]);
            data.Add(str[1]);
            data.Add(str[2]);
            data.Add(txtactivity.Text.Trim());
            data.Add(cmbtime.Text.Trim());
            data.Add("pending");
            String hr="",min="",tm="";
            hr = listhr.Text.Trim();
            min = listmin.Text.Trim();
            tm = listtm.Text.Trim();
            data.Add(hr+ ":" +min + " " + tm);
            data.Add(Session["user"].ToString());
            cols.Clear();
            cols.Add("id");
            cols.Add("styp");
            cols.Add("date");
            cols.Add("mon");
            cols.Add("yr");
            cols.Add("activity");
            cols.Add("time");
            cols.Add("sts");
            cols.Add("tm");
            cols.Add("userid");
            if (ff.Insertion("schedules", data, cols))
            {
                value = 1;
            }
            else
            {
                value = 0;
            }


        }
        catch (Exception ex)
        {
        }
        if (value == 0)
        {
            Response.Redirect("Error.aspx?err=Operation Failed!!&home=UserHome.aspx");
        }
        else
        {
            Response.Redirect("Success.aspx?msg1=Information Stored Successfully...!!&msg2=" + msg + "&msg3=" + msg + "&home=UserHome.aspx");
        }
    }
  
}