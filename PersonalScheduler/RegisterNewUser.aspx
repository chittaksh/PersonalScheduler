<%@ Page Language="C#" AutoEventWireup="true" CodeFile="RegisterNewUser.aspx.cs" Inherits="RegisterNewUser" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
<%Server.Execute("Top.htm"); %>
    <form id="form1" runat="server">
    <div id="main">
    <center><h2> New User Registration</h2></center>
    <table cellpadding="3" cellspacing="3" align="center">
    <tr>
    <td>User Name</td>
    <td>
        <asp:TextBox ID="txtunm" runat="server" CssClass="textbox"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ForeColor="Red" ControlToValidate="txtunm"></asp:RequiredFieldValidator>
    </td>
    </tr>
    <tr>
    <td>User id</td>
    <td>
        <asp:TextBox ID="txtuid" runat="server"  CssClass="textbox" AutoPostBack="true" OnTextChanged="CheckAvail"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ForeColor="Red" ControlToValidate="txtuid"></asp:RequiredFieldValidator><br />
        <asp:Label ID="Label1" runat="server" Text=" "></asp:Label>
    </td>
    </tr>
    <tr>
    <td>Password</td>
    <td>
        <asp:TextBox ID="txtpass" runat="server"  CssClass="textbox" TextMode="Password"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="*" ForeColor="Red" ControlToValidate="txtpass"></asp:RequiredFieldValidator>
    </td>
    </tr>
    <tr>
    <td>Retype Password</td>
    <td>
        <asp:TextBox ID="txtrpass" runat="server"  CssClass="textbox" TextMode="Password"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="*" ForeColor="Red" ControlToValidate="txtrpass"></asp:RequiredFieldValidator>
        <asp:CompareValidator ID="CompareValidator2" runat="server" 
            ErrorMessage="Passwords Mismatched!!" ControlToValidate="txtrpass" 
            ControlToCompare="txtpass" Operator="Equal" ForeColor="Red" 
            SetFocusOnError="True"></asp:CompareValidator>
    </td>
    </tr>
    <tr>
    <td>Security Question</td>
    <td>
        <asp:DropDownList ID="cmbsques" runat="server"  CssClass="combo">
        <asp:ListItem><---Select---></asp:ListItem>
        <asp:ListItem>What is your pet name?</asp:ListItem>
        <asp:ListItem>Which is your favorite place to visit?</asp:ListItem>
        <asp:ListItem>What is your hobby?</asp:ListItem>
        <asp:ListItem>Which is your favorite food to eat?</asp:ListItem>
        </asp:DropDownList>
        <asp:CompareValidator ID="CompareValidator1" runat="server" ErrorMessage="Please Select Security Question!!" ForeColor="Red" ControlToValidate="cmbsques" ValueToCompare="<---Select--->" Operator="NotEqual"></asp:CompareValidator>
    </td>
    </tr>
    <tr>
    <td>Answer</td>
    <td>
        <asp:TextBox ID="txtans" runat="server"  CssClass="textbox"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="*" ForeColor="Red" ControlToValidate="txtans"></asp:RequiredFieldValidator>
    </td>
    </tr>
    <tr>
    <td colspan="2" align="center">
        <asp:Button ID="Button1" runat="server" Text="Submit" OnClick="Submit" CssClass="buttonStyle" />
    </td>
    </tr>
    </table>
    </div>
    </form>
    <%Server.Execute("Bottom.htm"); %>
</body>
</html>
