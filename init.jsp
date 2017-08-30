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
	<title>売り上げシステム（初期画面）</title>
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

<div>
			<span class="itemName">商品：</span>
			<%-- <form:form modelAttribute="SalesForm">
				<form:input path = "quantity" /> --%>
					<%--<form:select path="goods" items="${ItemList}"/> --%>
		</div>
		<div>
			<span class="amount">点数：</span>
			<form:form modelAttribute="salesForm" action="/start">
			<form:input path="quantity" size="31" />
			</form:form>
		</div>
		<div>
			<input type="submit" name="meisaiadd" value="明細追加" />
		</div>
</body>
</html>
