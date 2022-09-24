<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Success.aspx.cs" Inherits="Success" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body >
    <form id="form1" runat="server">
       <%
    Server.Execute("TopNoNav.htm");
        %>
    <div id="main">
     
    <center>
     <br />
    <h3 ><%
            String msg1 = Request.QueryString["msg1"];
            String msg2 = Request.QueryString["msg2"];
            String msg3 = Request.QueryString["msg3"];
            string home = Request.QueryString["home"];
            Response.Write(msg1+"<br>"+msg2+"<br>"+msg3);
            %>
            </h3>
            <br />
       <h3 > <a href="<%=home%>">Home</a></h3>
       </center>
    </div>
    
    
       <%
    Server.Execute("Bottom.htm");
        %>
    </form>
</body>
</html>
