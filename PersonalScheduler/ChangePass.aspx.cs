using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections;
using System.Data;
public partial class ChangePass : System.Web.UI.Page
{
    ArrayList val1 = new ArrayList();
    ArrayList val = new ArrayList();
    string ops, nps, rps, uid;
    FunFactory ff = new FunFactory();
    string msg1 = "", msg2 = "", msg3 = "", home = "",utyp="";
    protected void Page_Load(object sender, EventArgs e)
    {
        utyp = Session["utype"].ToString();
        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1));
        Response.Cache.SetCacheability(HttpCacheability.NoCache);
        Response.Cache.SetNoStore();
    }
    protected void btnreg_Click(object sender, EventArgs e)
    {
        uid = Session["user"].ToString();
        ops = opass.Text.Trim();
        nps = npass.Text.Trim();
        rps = rpass.Text.Trim();

        if (nps.Equals(rps))
        {
            val1 = ff.ExecuteQuery("select  pass from users where userid='" + uid + "' and pass='" + ops.Trim() + "' ", 1);
            if (val1.Count > 0)
            {
 

                val = ff.ExecuteQuery("update users set pass='" + nps + "' where userid='" + uid + "' and pass='" + ops + "'", 1);
                String msg1 = "Password Changed successfully ...";
                String msg2 = uid + " your new Password is " + nps;
                String msg3 = " ";
              String  home = "UserHome.aspx";
                Response.Redirect("Success.aspx?msg1=" + msg1 + "&msg2=" + msg2 + "&msg3=" + msg3 + "&home=" + home);

            }
            else
            {
                msg1 = "Identity Mismatched!!!";
                home ="UserHome.aspx";

                Response.Redirect("Error.aspx?err=" + msg1 + "&msg2=" + msg2 + "&msg3=" + msg3 + "&home=" + home);

            }


        }
        else
        {
            msg1 = "Passwords Mismatched!!!";
            home = "UserHome.aspx";

            Response.Redirect("Error.aspx?err=" + msg1 + "&msg2=" + msg2 + "&msg3=" + msg3 + "&home=" + home);

        }

    }

}
