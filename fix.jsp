<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.*" %>
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




<form:form modelAttribute="salesForm" action="/sales/system">



<span style="color:blue;">
<c:out value="${s_msg}" />
</span>
<span style="color:red;">
<c:out value="${e_msg}" />
</span>

<%--売り上げIDを求める --%>
<%
	/*LocalDateTime from = LocalDateTime.of(1970, 1, 1,  0,  0);
	LocalDateTime to = LocalDateTime.now();*/
	DateTimeUtils.currentTimeMillis();
	DateTimeUtils.setCurrentMillisFixed(millis);
	Duration duration = Duration.minusMillis(from);
%>
売上ID = <%= duration %>
<br><br><br>


売上明細<br>
<table border = "1">
<tr><th>削除</th><th>商品ID</th><th>商品名</th><th>単価</th><th>点数</th><th>小計</th></tr>



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
