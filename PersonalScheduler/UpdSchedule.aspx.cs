using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
public partial class UpdSchedule : System.Web.UI.Page
{
    DataSet ds = new DataSet();
    FunFactory ff = new FunFactory();
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            ds=ff.FetchData("select * from schedules where userid='"+Session["user"].ToString()+"'");
            if (ds.Tables[0].Rows.Count == 0)
            {
                ds.Tables[0].Rows.Add();
                ds.Tables[0].Rows[0][3] = "No Record Found!!";
                grdsch.Columns[0].Visible = false;
            }
            else
                grdsch.Columns[0].Visible = true;
            grdsch.DataSource = ds;
            grdsch.DataBind();
        }
        catch (Exception ex)
        {
        }
        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1));
        Response.Cache.SetCacheability(HttpCacheability.NoCache);
        Response.Cache.SetNoStore();
    }
}