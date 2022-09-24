using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Collections;
public partial class RegisterNewUser : System.Web.UI.Page
{
    ArrayList cols = new ArrayList();
    ArrayList data = new ArrayList();
    FunFactory ff = new FunFactory();
    DataSet ds = new DataSet();
    int value = 0;
    String msg = "";
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Submit(object sender, EventArgs e)
    {
        try
        {
            data.Clear();
            data.Add(txtuid.Text.Trim());
            data.Add(txtunm.Text.Trim());
            data.Add(txtpass.Text.Trim());
          
            data.Add(cmbsques.Text.Trim());
            data.Add(txtans.Text.Trim());

            cols.Clear();
            cols.Add("uid");
            cols.Add("unm");
            cols.Add("pass");
           
            cols.Add("ques");
            cols.Add("ans");
            if (ff.Insertion("users", data, cols))
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
            Response.Redirect("Error.aspx?err=Operation Failed!!&home=Default.aspx");
        }
        else
        {
            Response.Redirect("Success.aspx?msg1=You are Registered Successfully...!!&msg2="+msg+"&msg3="+msg+"&home=Default.aspx");
        }
    }
    protected void CheckAvail(object sender, EventArgs e)
    {
        ds.Clear();
        ds = ff.FetchData("select userid from users where userid='" + txtuid.Text.Trim() + "'");
        if (ds.Tables[0].Rows.Count > 0)
        {
            Label1.Text = "Userid is not available, Please try another!!";
            Label1.ForeColor = System.Drawing.Color.Red;
            txtuid.Focus();

        }
        else
        {

            Label1.Text = "Userid is available";
            Label1.ForeColor = System.Drawing.Color.Green;
             
        }
    }
}