<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
<%Server.Execute("Top.htm"); %>
    <form id="form1" runat="server">
    <div id="main">
    <div class="leftcolumn"><br />
        <asp:Login ID="Login1" runat="server" Height="154px" Width="348px" 
            BackColor="White" BorderColor="#804040" BorderPadding="4" BorderStyle="Solid" 
            BorderWidth="1px" DisplayRememberMe="False" Font-Names="cambria" 
            Font-Size="12px" ForeColor="#333333" onauthenticate="Login1_Authenticate">
            <InstructionTextStyle Font-Italic="True" ForeColor="Black" />
            <LoginButtonStyle BackColor="#FFC90D" BorderColor="#CCCCCC" BorderStyle="Solid" 
                BorderWidth="1px" Font-Names="Verdana" Font-Size="12px" ForeColor="#284775" />
            <TextBoxStyle Font-Size="12px" />
            <TitleTextStyle BackColor="#E6813A" Font-Bold="True" Font-Size="14px" 
                ForeColor="White" />
        </asp:Login>
        <br />
       <a href="RegisterNewUser.aspx"><img src="images/reg12.jpg" style=" width: 170px" /><br /> Register Me</a> 
        </div>
        <div class="rightcolumn"><br />
        <img src="images/2Do To do List.jpg" width="600px" style="height: 350px"/>
        </div>
    </div>
    </form>
    <%Server.Execute("Bottom.htm"); %>
</body>
</html>
