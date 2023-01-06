<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,jakarta.mail.*"%>
<%@ page import="jakarta.mail.internet.*,jakarta.activation.*"%>
<%@ page import="jakarta.servlet.http.*,jakarta.servlet.*" %>
<%@ page import = "cz.vutbr.fit.knot.gja.mail.MailBean" %>
<jsp:useBean id="mailBean" class="cz.vutbr.fit.knot.gja.mail.MailBean" scope="session"/>
<jsp:setProperty name="mailBean" property="*"/> 
<%

  String result;
  // Recipient's email ID needs to be mentioned.
  String to = mailBean.getMailto();
  // Sender's email ID needs to be mentioned
  String from = mailBean.getMailfrom();
  // Assuming you are sending email from localhost
  String host = "localhost";
  // Get system properties object
  Properties properties = System.getProperties();
  // Setup mail server
  properties.setProperty("mail.smtp.host", host);
  // Get the default Session object.
  Session mailSession = Session.getDefaultInstance(properties);
  try {
    // Create a default MimeMessage object.
    MimeMessage message = new MimeMessage(mailSession);
    // Set From: header field of the header.
    message.setFrom(new InternetAddress(from));
    // Set To: header field of the header.
    message.addRecipient(Message.RecipientType.TO,
            new InternetAddress(to));
    // Set Subject: header field
    message.setSubject(mailBean.getMailsubject());
    // Send the actual HTML message, as big as you like
    message.setContent(mailBean.getMailcontent(), "text/plain");
    // Send message
    Transport.send(message);
    result = "Sent message successfully....";
  } catch (MessagingException mex) {
    mex.printStackTrace();
    result = "Error: unable to send message....";
  }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Send HTML Email using JSP</title>
    </head>
    <body>
        <center>
            <h1>Send Email using JSP</h1>
        </center>
        <p align="center">
            <%
              out.println("Result: " + result + "\n");
            %>
        </p>
    </body>
</html>