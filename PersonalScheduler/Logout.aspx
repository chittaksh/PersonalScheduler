<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Logout.aspx.cs" Inherits="Logout" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
<% Server.Execute("TopNoNav.htm"); %>
  <div id="main">
    <form id="form1" runat="server">
    
     <table width="700" cellspacing="0" border="0" align="center">
      <tr>
        <td width="500" height="300" align="center" valign="middle">
        <table border="0" width="500">
        <tr>
        <td><img src="images/Log-Out-icon.png" alt="Images" /></td>
        <td valign="top" align="center"><h4>You Have Successfully Logout </h4>
        <br /><br />
        &nbsp;&nbsp; &nbsp;<a href="Default.aspx">Home</a></td>
        </tr>
        </table>
        </td>
        </tr>
       
        </table>
   
    </form>
 </div>
    <% Server.Execute("Bottom.htm"); %>
</body>
</html>
