<%@ Page Language="C#" AutoEventWireup="true" CodeFile="NewSchedule.aspx.cs" Inherits="NewSchedule" %>

<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="asp" %>

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
    <center><h2>New Schedule Entry</h2></center>
    <br />
    <table cellpadding="3" cellspacing="3" align='center'>
    <tr>
    <td>Schedule Type</td>
    <td>
        <asp:DropDownList ID="cmbstyp" runat="server" CssClass="combo">
        <asp:ListItem><---Select---></asp:ListItem>
        <asp:ListItem>ToDo</asp:ListItem>
        <asp:ListItem>Meeting</asp:ListItem>
        <asp:ListItem>Payment</asp:ListItem>
        </asp:DropDownList>
           <asp:CompareValidator ID="CompareValidator1" runat="server" 
                        ErrorMessage="Please Select Schedule Type!!" ForeColor="Red" 
                        ControlToValidate="cmbstyp" Operator="NotEqual" 
                        ValueToCompare="&lt;---Select---&gt;"></asp:CompareValidator>
    </td>
    </tr>
    <tr>
    <td>Date</td>
    <td>
    <asp:TextBox ID="txtdt" runat="server" CssClass="textbox"></asp:TextBox>
        <asp:ToolkitScriptManager ID="ToolkitScriptManager1" runat="server">
        </asp:ToolkitScriptManager>
        
      <asp:ImageButton runat="Server" ID="Image1"   ImageUrl="~/images/calender.JPG" 
                        AlternateText="Click to show calendar" Height="25px" Width="25px" 
                        CausesValidation="False" /> 
         <asp:CalendarExtender ID="CalendarExtender4" runat="server"   TargetControlID="txtdt" PopupButtonID="Image1" Format="dd/MM/yyyy" /> 
                
     <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ForeColor="Red" ControlToValidate="txtdt"></asp:RequiredFieldValidator>
    </td>
    </tr>
    <tr>
    <td>Time </td>
    <td>
  
        <asp:DropDownList ID="listhr" runat="server">
 
        
        </asp:DropDownList>
  
        <asp:DropDownList ID="listmin" runat="server">
     
        
        </asp:DropDownList>
 
        <asp:DropDownList ID="listtm" runat="server">
        
        
        </asp:DropDownList>
    </td>
    </tr>
    <tr>
    <td>Activity</td>

    <td>
        <asp:TextBox ID="txtactivity" runat="server" CssClass="textbox"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ForeColor="Red" ControlToValidate="txtactivity"></asp:RequiredFieldValidator>

    </td>
    </tr>
        <tr>
    <td>Remember Before</td>
    <td>
        <asp:DropDownList ID="cmbtime" runat="server" CssClass="combo">
        <asp:ListItem><---Select---></asp:ListItem>
        <asp:ListItem>30 min</asp:ListItem>
        <asp:ListItem>1 hr</asp:ListItem>
        <asp:ListItem>1 day</asp:ListItem>
        
        </asp:DropDownList>
        <asp:CompareValidator ID="CompareValidator2" runat="server" 
                        ErrorMessage="Please Select Time!!" ForeColor="Red" 
                        ControlToValidate="cmbtime" Operator="NotEqual" 
                        ValueToCompare="&lt;---Select---&gt;"></asp:CompareValidator>
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
    <%}
      else
      {
        Response.Redirect("Invalid.htm");
    } %>
</body>
</html>
