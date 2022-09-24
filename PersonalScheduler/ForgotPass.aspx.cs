using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections;
public partial class ForgotPass : System.Web.UI.Page
{
    ArrayList val = new ArrayList();
    string ops, nps, rps, uid;
    FunFactory ff = new FunFactory();
    ArrayList val1 = new ArrayList();
    String msg1 = "";
    String msg2 = "";
    String msg3 = " ";
    String home = "";
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Register(object sender, EventArgs e)
    {
        uid = txtuid.Text.Trim();
        val1 = ff.ExecuteQuery("select userid from users where userid='" + uid + "'  and sques='" + cmbsques.Text.Trim() + "' and sans='" + txtans.Text.Trim() + "'", 1);
        if (val1.Count > 0)
        {
            Random rnd = new Random();
            int r = rnd.Next(0, 99);
            nps = cmbsques.Text.Trim().Substring(0, 2).ToUpper() + "@sch@"+r;
            uid = txtuid.Text.Trim();
            val = ff.ExecuteQuery("update users set pass='" + nps + "' where userid='" + uid + "'", 1);
            String msg1 = uid + " your password changed successfully..";
            String msg2 = "Your new password is " + nps;
            String msg3 = " ";
            String home = "Default.aspx";
            Response.Redirect("Success.aspx?msg1=" + msg1 + "&msg2=" + msg2 + "&msg3=" + msg3 + "&home=" + home);
        }
        else
        {
            msg1 = "Identity Mismatched!!!";
            home = "Default.aspx";

            Response.Redirect("Error.aspx?err=" + msg1 + "&msg2=" + msg2 + "&msg3=" + msg3 + "&home=" + home);

        }
    }
}