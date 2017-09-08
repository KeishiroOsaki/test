<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/sales/resources/css/common.css" />
	<title>売り上げシステム（明細追加画面）</title>
</head>
<body>
<div class="header">
	××オンラインショップ
	<%  Calendar calendar = Calendar.getInstance();
   		SimpleDateFormat sdf = new SimpleDateFormat();
   		sdf.applyPattern("MM月dd日(E)");
   		System.out.println(sdf.format(calendar.getTime())); %>
   	<%= sdf.format(calendar.getTime()) %>
</div>



<%
	//個数数値変換
	String snum = null;
	int num = 0;
	snum = request.getParameter("quantity");
	num = Integer.parseInt(snum);

%>

<form:form modelAttribute="salesForm" action="/sales/system">
<%--    <div>
        <span class="itemName">商品：</span>
        <form:select path="name" items="${ItemList}"/>
    </div>
    <div>
        <span class="amount">点数：</span>
        <form:input path="quantity" size="31" />
    </div>
    <div>
        <input type="submit" name="add" value="明細追加" />
    </div>  --%>




<span style="color:blue;">
<c:out value="${s_msg}" />
</span>
<span style="color:red;">
<c:out value="${e_msg}" />
</span>

売上明細
<table border = "1">
<tr><th>削除</th><th>商品ID</th><th>商品名</th><th>単価</th><th>点数</th><th>小計</th></tr>

<td><c:out value="<%= num %>" /></td>

<%--けす<c:forEach var="i" items="${recordList}">
<tr>
<%-- ラジオボタン<td><form:radiobutton ></td>
いったんけす<td><c:out value="${i.getId()}" /></td> --%>

<%-- けす
<td><c:out value="num" /></td>

<td><c:out value="${i.getName()}" /></td>
<td><c:out value="${i.getPrice()}" /></td>
<td><c:out value="${i.getQuantity()}" /></td>
<td><c:out value="${i.getSubtotal()}" /></td>
</tr>
</c:forEach> --%>
</table>


<input type="submit" name="delete" value="削除" />
<input type="submit" name="fix" value="確定" />
</form:form>
</body>
</html>
