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
<form:form modelAttribute="SalesForm" action="meisaiadd">
    <div>
        <span class="itemName">商品：</span>
        <form:select path="name" items="${ItemList}"/>
    </div>
    <div>
        <span class="amount">点数：</span>
        <form:input path="quantity" size="31" />
    </div>
    <div>
        <input type="submit" value="明細追加" />
    </div>
</form:form>

<span style="color:blue;">
<c:out value="${s_msg}" />
</span>
<span style="color:red;">
<c:out value="${e_msg}" />
</span>

売上明細
<table>
<tr><th>削除</th><th>商品ID</th><th>商品名</th><th>単価</th><th>点数</th><th>小計</th></tr>
<c:forEach var="i" items="${recordList}">
<tr>
<td><form:radiobutton ></td>
<td><c:out value="${i.getId()}"></td>
<td><c:out value="${i.getName()}"></td>
<td><c:out value="${i.getPrice()}"></td>
<td><c:out value="${i.getQuantity()}"></td>
<td><c:out value="${i.getSubtotal()}"></td>
</tr>
</c:forEach>
</table>

</body>
</html>
