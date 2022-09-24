<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DeleteSchedule.aspx.cs" Inherits="DeleteSchedule" %>

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
    <center><h2>Update Schedules</h2></center>
    <br /><center>
         <asp:GridView ID="grdsch" runat="server"  DataKeyNames="sid" OnPageIndexChanging="Paging"
             CellPadding="3" AllowPaging="True" 
            PageSize="20" BackColor="#DEBA84" BorderColor="#DEBA84" BorderStyle="None" 
                BorderWidth="1px" CellSpacing="2" >
                    <Columns>
           <asp:TemplateField>
            <ItemTemplate>
                <asp:CheckBox ID="select" runat="server"/>
            </ItemTemplate>
           
           </asp:TemplateField>     
 
            </Columns>
       
            <FooterStyle BackColor="#F7DFB5" ForeColor="#8C4510" />
            <HeaderStyle BackColor="#A55129" Font-Bold="True" ForeColor="White" />
            <PagerStyle ForeColor="#8C4510" HorizontalAlign="Center" />
            <RowStyle BackColor="#FFF7E7" ForeColor="#8C4510" />
            <SelectedRowStyle BackColor="#738A9C" Font-Bold="True" ForeColor="White" />
            <SortedAscendingCellStyle BackColor="#FFF1D4" />
            <SortedAscendingHeaderStyle BackColor="#B95C30" />
            <SortedDescendingCellStyle BackColor="#F1E5CE" />
            <SortedDescendingHeaderStyle BackColor="#93451F" />
        </asp:GridView>
    </center>
     <br /><br /> 
      <center>  <asp:Button ID="Button1" runat="server" Text="Delete" CssClass="buttonStyle" OnClick="Delete" OnClientClick="javascript:return confirm('Are you sure you want to delete selected notices?')" />
        </center><br />
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
