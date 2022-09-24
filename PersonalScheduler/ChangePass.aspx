<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ChangePass.aspx.cs" Inherits="ChangePass" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
  <% if (!Session["user"].ToString().Equals("Not Defined"))
        {
             
      
                Server.Execute("top.aspx");
           
           %>
     <form id="form1" runat="server">
     
   <div id="main">   <br />
   
     <div class="leftcolumn">
    <br /> 
     
    <center> <h2>Change Password</h2></center>
     <br />
    <table style='text-align:justify' align="center" style="background-color: #fff;">
 
    <tr>
        <td>Current Password</td>
        <td><asp:TextBox ID="opass"  TextMode="Password" runat="server" CssClass="textbox"></asp:TextBox>&nbsp;<asp:RequiredFieldValidator 
                ID="RequiredFieldValidator2" runat="server" ControlToValidate="opass" 
                ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator></td>
    </tr>
    <tr>
        <td>New Password</td>
        <td><asp:TextBox ID="npass"  TextMode="Password" runat="server"  CssClass="textbox"></asp:TextBox>&nbsp;<asp:RequiredFieldValidator 
                ID="RequiredFieldValidator3" runat="server" ControlToValidate="npass" 
                ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator></td>
    </tr>
    <tr>
        <td>Retype Password</td>
        <td><asp:TextBox ID="rpass"  TextMode="Password" runat="server"  CssClass="textbox"></asp:TextBox>&nbsp;<asp:RequiredFieldValidator 
                ID="RequiredFieldValidator4" runat="server" ControlToValidate="rpass" 
                ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator></td>
    </tr>  
    <tr><td></td><td>
        <asp:CompareValidator ID="CompareValidator1" runat="server" 
                ControlToCompare="npass" ControlToValidate="rpass" 
                ErrorMessage="Passwords Mismatched" SetFocusOnError="true"  ForeColor="Red"></asp:CompareValidator></td></tr> 
    </table>
     <br />
    <table align="center">
    <tr>
        <td>
            <asp:Button ID="btnreg" runat="server" Text="Submit" Width="95px" CssClass="buttonStyle"
                onclick="btnreg_Click" /></td>
        
    </tr>
    </table> 
    </div>
    <div class="rightcolumn">
    <img src="images/change.jpg"   />
    </div>
     </div>
     </form>
    <% }
       else
       {
          Response.Redirect("Invalid.htm");
        } %>
         <% Server.Execute("Bottom.htm"); %>   
  

</body>
</html>
