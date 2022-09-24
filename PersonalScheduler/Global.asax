<%@ Application Language="C#" %>

<script runat="server">

    void Application_Start(object sender, EventArgs e) 
    {
        // Code that runs on application startup
    

    }
    
    void Application_End(object sender, EventArgs e) 
    {
        //  Code that runs on application shutdown
       

    }
        
    void Application_Error(object sender, EventArgs e) 
    { 
        // Code that runs when an unhandled error occurs

    }

    void Session_Start(object sender, EventArgs e) 
    {
        // Code that runs when a new session is started

        Session["user"] = "Not Defined";
        Session["utype"] = "Not Defined";
        Session["stfid"] = "0";
        Session["studid"] = "0";
        Session["branch"] = "Not Defined";
        Session["sem"] = "Not Defined";
        Session["collegecd"] = "Not Defined";
        Session["type"] = "Not Defined";
        Session["path"] = "Not Defined";
    }

    void Session_End(object sender, EventArgs e) 
    {
        Session["collegecd"] = "Not Defined";
        Session["user"] = "Not Defined";
        Session["utype"] = "Not Defined";
        Session["path"] = "Not Defined";
        Session["stfid"] = "0";
        Session["studid"] = "0";
        Session["branch"] = "Not Defined";
        Session["sem"] = "Not Defined";
        Session["type"] = "Not Defined";
        // Code that runs when a session ends. 
        // Note: The Session_End event is raised only when the sessionstate mode
        // is set to InProc in the Web.config file. If session mode is set to StateServer 
        // or SQLServer, the event is not raised.

    }
       
</script>
