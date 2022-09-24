using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
public partial class UdpateSchedule : System.Web.UI.Page
{
    int sid = 0;
    FunFactory ff = new FunFactory();
    DataSet ds = new DataSet();
    int value = 0;
    String msg = "";
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            sid = Convert.ToInt32(Request.QueryString["sid"].ToString());
            ds = ff.FetchData("select * from schedules where userid='" + Session["user"].ToString() + "' and sid=" + sid);
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

                if (ds.Tables[0].Rows.Count > 0)
                {
                    cmbstyp.Text = ds.Tables[0].Rows[0]["schtype"].ToString();
                    txtdt.Text = ds.Tables[0].Rows[0]["date"].ToString() + "/" + ds.Tables[0].Rows[0]["month"].ToString() + "/" + ds.Tables[0].Rows[0]["year"].ToString();
                    txtactivity.Text = ds.Tables[0].Rows[0]["activity"].ToString();
                    cmbtime.Text = ds.Tables[0].Rows[0]["remember"].ToString();
                    String tm = ds.Tables[0].Rows[0]["stime"].ToString();
                    String[] str = tm.Split(':');
                    listhr.Text = str[0];
                    String[] str1 = str[1].Split(' ');
                    listmin.Text = str1[0];
                    listtm.Text = str1[1];
                }
            }
        }
        catch (Exception ex)
        {
        }
        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1));
        Response.Cache.SetCacheability(HttpCacheability.NoCache);
        Response.Cache.SetNoStore();
    }
    protected void Submit(object sender, EventArgs e)
    {
        try
        {
            String[] str = txtdt.Text.Trim().Split('/');
            String qr = "update schedules set schtype='" + cmbstyp.Text.Trim() + "',date='" + str[0] + "',month='" + str[1] + "',year='" + str[2] + "',activity='" + txtactivity.Text.Trim() + "',remember='" + cmbtime.Text.Trim() + "'";
            qr += ",stime='" + listhr.Text.Trim() + ":" + listmin.Text.Trim() + " " + listtm.Text.Trim() + "' where userid='" + Session["user"].ToString() + "' and sid=" + sid;
            if (ff.Execute(qr))
            {
                value++;

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
            Response.Redirect("Success.aspx?msg1=Information Updated Successfully...!!&msg2=" + msg + "&msg3=" + msg + "&home=UserHome.aspx");
        }
    }
}