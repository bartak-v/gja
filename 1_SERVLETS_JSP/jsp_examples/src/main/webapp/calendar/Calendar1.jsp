<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
  <HEAD>
    <TITLE>Calendar: A JSP APPLICATION</TITLE>
  </HEAD>


  <BODY BGCOLOR="white">

    <%@ page language="java" import="cz.vutbr.fit.knot.gja.calendar.*" %>
    <jsp:useBean id="table" scope="session" class="cz.vutbr.fit.knot.gja.calendar.TableBean" />

    <%
      table.processRequest(request);
      if (table.getProcessError() == false) {
    %>

    <!-- html table goes here -->
    <CENTER>
      <TABLE WIDTH="60%" BGCOLOR="yellow" CELLPADDING=15>
        <TR>
          <TD ALIGN="CENTER"> <A HREF="Calendar1.jsp?date=prev"> prev </A>
          <TD ALIGN="CENTER"> Calendar:<%= table.getDate()%></TD>
          <TD ALIGN="CENTER"> <A HREF="Calendar1.jsp?date=next"> next </A>
        </TR>
      </TABLE>

      <!-- the main table -->
      <FORM METHOD="POST" ACTION="Calendar1.jsp">
      <TABLE WIDTH="60%" BGCOLOR="lightblue" BORDER="1" CELLPADDING="10">
        <TR>
          <TH> Time </TH>
          <TH> Appointment </TH>
        </TR>
          <%
            for (int i = 0; i < table.getEntries().getRows(); i++) {
              cz.vutbr.fit.knot.gja.calendar.Entry entr = table.getEntries().getEntry(i);
          %>
          <TR>
            <TD> 
              <A HREF="Calendar2.jsp?time=<%= entr.getHour()%>">
                <%= entr.getHour()%> </A>
            </TD>
            <TD BGCOLOR="<%= entr.getColor()%>">
              <%= entr.getDescription()%>
            </TD> 
          </TR>
          <%
            }
          %>
        
      </TABLE>
      </FORM>
      <BR>

      <!-- footer -->
      <TABLE WIDTH="60%" BGCOLOR="yellow" CELLPADDING="15">
        <TR>
          <TD ALIGN="CENTER">  <%= table.getName()%> : 
            <%= table.getEmail()%> </TD>
        </TR>
      </TABLE>
    </CENTER>

    <%
    } else {
    %>
    <font size="5">
      You must enter your name and email address correctly.
    </font>
    <%  }
    %>


  </BODY>
</HTML>
