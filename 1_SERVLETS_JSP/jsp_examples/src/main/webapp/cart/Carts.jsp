<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <!--
    Copyright (c) 1999 The Apache Software Foundation.  All rights 
    reserved.
  -->

  <jsp:useBean id="cart" scope="session" class="cz.vutbr.fit.knot.gja.cart.DummyCart" />

  <jsp:setProperty name="cart" property="*" />
  <%
    cart.processRequest(request);
  %>


  <FONT size = 5 COLOR="#CC0000">
    <br> You have the following items in your cart:
    <ol>
      <%
        java.util.List<String> items = cart.getItems();
        for (int i = 0; i < items.size(); i++) {
      %>
      <li> <%= items.get(i)%> </li>
        <%
          }
        %>
    </ol>

  </FONT>

  <hr>
  <%@ include file ="Carts.html" %>
</html>