<%@ Page Language="C#" AutoEventWireup="true" CodeFile="top.aspx.cs" Inherits="top" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
       <%
       try
{
  String userid=(Session["user"].ToString());
  String typ=Session["utype"].ToString();
 
   

%>
    <center>
           <img src="images/top.png" alt="top" width="70%"/> 
 
           <div  width="70%" id="menu"  >
            <ul id="menustrip">
                
                 <li><a href="Logout.aspx"> Logout</a></li>
                 <% if(!typ.Equals("CloudAdmin")){ %>
                 <li><a href="ChangePass.aspx">Change Password</a></li>
                 <%}%>
                  <li><a href="UserHome.aspx"> Home</a></li>
                  
            </ul>
        </div>
   
   
      <table cellpadding="8" cellspacing="8" align="right" style="margin-right:200px;vertical-align:top"><tr><td style="width:150px;align:center">
     
      </td>
      <td> <table id="userpannel" align="right" cellpadding="5" >
            <tr>
           
            <td>Logged in as <%=Session["user"]%></td><td>(<%=Session["utype"]%> )</td>
            </tr>
            
    </table> </td>
      </tr></table><br /><br /><br /><br />
               <%

}
       catch(Exception ex)
      {
          Response.Redirect("Invalidate.aspx");
      }                                   
%>
        </center>
    </body>
</html>
