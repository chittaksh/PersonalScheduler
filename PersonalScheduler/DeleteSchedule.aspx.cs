using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections;
using System.Data;
public partial class DeleteSchedule : System.Web.UI.Page
{
    FunFactory ff = new FunFactory();

    int value = 0;
    String msg1 = "", msg2 = "", msg3 = "";
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            FillGrid();
        }
        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1));
        Response.Cache.SetCacheability(HttpCacheability.NoCache);
        Response.Cache.SetNoStore();
    }
    protected void Paging(object sender, GridViewPageEventArgs e)
    {
        grdsch.PageIndex = e.NewPageIndex;
        FillGrid(); //bindgridview will get the data source and bind it again
    }
    public void FillGrid()
    {
        try
        {
         DataSet  ds = ff.FetchData("select * from schedules where userid='" + Session["user"].ToString() + "'");
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
    }
    protected void Delete(object sender, EventArgs e)
    {

        try
        {
            ArrayList arr = new ArrayList();

            foreach (GridViewRow row in grdsch.Rows)
            {
                CheckBox cb = (CheckBox)row.FindControl("select");
                if (cb != null && cb.Checked)
                {
                    int sid = Convert.ToInt32(grdsch.DataKeys[row.RowIndex].Value);


                    if (ff.Execute("delete from schedules where sid=" + sid))
                    {
                        value = 1;
                    }


                }
            }
             
            if (value > 0)
            {
                msg1 = "Selected schedules deleted successfully...";

                Response.Redirect("Success.aspx?msg1=" + msg1 + "&msg2=" + msg2 + "&msg3=" + msg3 + "&home=UserHome.aspx");
            }
            else
            {
                msg1 = "Operation Failed!!";

                Response.Redirect("Error.aspx?err=" + msg1 + "&home=UserHome.aspx");
            }
        }
        catch (Exception ex)
        {
        }
    }
}