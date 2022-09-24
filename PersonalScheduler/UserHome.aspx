<%@ Page Language="C#" AutoEventWireup="true" CodeFile="UserHome.aspx.cs" Inherits="UserHome" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
<%
    if(!(Session["user"].ToString().Equals("Not Defined")))
    {
     %>
<%Server.Execute("Top.aspx"); %>
    <form id="form1" runat="server">
    <div id="main">
    <center><h2>User Home</h2></center>
    <div class="leftcolumn">
    <img src="images/userhome.jpg" />

    </div>
    <div class="rightcolumn">
    <ul id="sidebar">
    <li><a href="NewSchedule.aspx">New Schedule</a></li>
     <li><a href="UpdSchedule.aspx">Modify My Schedules</a></li>
      <li><a href="DeleteSchedule.aspx">My Schedules</a></li>
    </ul>
    </div>
    </div>
    </form>
    <%Server.Execute("Bottom.htm"); %>
    <%}
      else
      {
        Response.Redirect("Invalid.htm");
    } %>
</body>
</html>
