<%@ page import="webshop.basket.BasketOrder"%>

<%
String type =(String)request.getParameter("param1");
String name =(String)request.getParameter("param2");
String id = (String)request.getParameter("param3");
out.println(name + " Added to the Basket");
BasketOrder.addOrder(type,id);
%>