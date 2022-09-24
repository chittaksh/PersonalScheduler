<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ForgotPass.aspx.cs" Inherits="ForgotPass" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
     
    <% Server.Execute("Top.htm"); %>
       <div id="main">
       <br /><br />
       <div class="leftcolumn"><br /><br />
        <center><h2>Password Recovery</h2></center> 
       <table align="center" style="background-color: #fff;" width="500" cellpadding="4">
  
    <tr>
    <td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; User Id</td>
    <td>
        <asp:TextBox ID="txtuid" runat="server" CssClass="textbox"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
            ControlToValidate="txtuid" ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
        </td>
    </tr>   
      <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Security Question</td>
     
                <td><asp:DropDownList ID="cmbsques" runat="server">
                    <asp:ListItem>Select Security Question</asp:ListItem>
                     <asp:ListItem>What is your pet name?</asp:ListItem>
                     <asp:ListItem>What is your favorite  teachers name?</asp:ListItem>
                    <asp:ListItem>What is your hobby?</asp:ListItem>
                 </asp:DropDownList>   
                    
                </td>
    </tr>
        <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Security Answer</td>
    <td>
        
        <asp:TextBox ID="txtans" runat="server" CssClass="textbox"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
                ErrorMessage="*" ControlToValidate="txtans" SetFocusOnError="True" 
            ForeColor="Red"></asp:RequiredFieldValidator>
                  
                    </td>
        
    </tr>   
       <tr>
    <td colspan="2" align="center">
        <asp:Button ID="btnReg" runat="server" Text="Submit" OnClick="Register" CssClass="buttonStyle" />
    </td>
    <br /><br />
    </tr>
    </table>  
    </div>
    <div class="rightcolumn">
    <img src="images/change.jpg" />
    </div> 
    </div>
    <% Server.Execute("Bottom.htm"); %> 
    
    </form>
</body>
</html>
    
