<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--  
      Copyright (c) 1999 The Apache Software Foundation.  All rights 
      reserved.
    -->

    <HEAD>
        <TITLE>Calendar: A JSP APPLICATION</TITLE>
    </HEAD>


    <BODY BGCOLOR="white">
        <jsp:useBean id="table" scope="session" class="cz.vutbr.fit.knot.gja.calendar.TableBean" />

        <%
          String time = request.getParameter("time");
        %>

        <FONT SIZE=5> Please add the following event:
            <BR> <h3> Date <%= table.getDate()%>
                <BR> Time <%= time%> </h3>
        </FONT>
        <FORM METHOD="POST" ACTION="Calendar1.jsp">
            <BR> 
            <BR> <INPUT NAME="date" TYPE="HIDDEN" VALUE="current">
            <BR> <INPUT NAME="time" TYPE="HIDDEN" VALUE="<%= time%>">
            <BR> <h2> Description of the event <INPUT NAME="description" TYPE="TEXT" SIZE="20"> </h2>
            <BR> <INPUT TYPE="SUBMIT" VALUE="submit">
        </FORM>

    </BODY>
</html>
