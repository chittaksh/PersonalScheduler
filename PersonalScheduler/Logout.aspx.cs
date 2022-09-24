using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Web.Security;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;

public partial class Logout : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Session.Abandon();
        FormsAuthentication.SignOut();
        //Roles.DeleteCookie();
        //Session.Clear();
        Session["user"] = "Not Defined";
        Session["utype"] = "Not Defined";
        Session["stfid"] = "0";
        Session["studid"] = "0";
        Session["branch"] = "Not Defined";
        Session["sem"] = "Not Defined";
       // Response.Redirect("Default.aspx");
        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1));
        Response.Cache.SetCacheability(HttpCacheability.NoCache);
        Response.Cache.SetNoStore();
    }
}