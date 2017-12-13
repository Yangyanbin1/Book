<%@page import="com.oracle.book.service.BookService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍库存登记系统</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function del(id) {
		var flag = window.confirm("确认删除吗?");
		if (flag) {
			location.href = "BookDeleteServlet?id=" + id;
		}
	}
</script>
<style type="text/css">
table {
	border-collapse: collapse;
	text-align: center;
}
</style>
</head>
<body>
	<center>
		<table width="80%" border="1" cellpadding="0" cellspacing="0"
			bordercolor="#FF0000;" id="table">
			<tr>
				<td colspan="2"><img src="images/banner.png" alt="书籍库存登记系统"
					width="100%" /></td>
			</tr>
			<tr>
				<td width="22%" height="480" valign="top"
					background="images/bg_left.png"><br /> <br />
					<center>
						<p>
							<font color="#13598b" size="4"> <img
								src="images/icon_listlia.gif" /> <a href="index.html"><B>首页信息</B></a>
							</font>
						</p>
					</center>
					<center>
						<p>
							<font color="#13598b" size="4"> <img
								src="images/icon_listlia.gif" /> <a href="BookRegister.jsp"><B>入库登记</B></a>
							</font>
						</p>
					</center>
					<center>
						<p>
							<font color="#13598b" size="4"> <img
								src="images/icon_listlia.gif" /> <a href="ListBooks.jsp"><B>库存列表</B></a>
							</font>
						</p>
					</center>

					<center>
						<p>
							<font color="#13598b" size="4"> <img
								src="images/icon_listlia.gif" /> <a
								href="ListBookByPageServlet"><B>库存列表分页展示</B></a>
							</font>
						</p>
					</center></td>
				<td width="78%" valign="top" align="left"><br /> <jsp:useBean
						id="bookSvc" class="com.oracle.book.service.BookDAO" scope="page"></jsp:useBean>
					<table
						style="border: 1px solid black; margin: 0 auto; width: 600px; margin-top: -225px;">
						<tr>
							<td style="border: 1px solid black">编号</td>
							<td style="border: 1px solid black">书名</td>
							<td style="border: 1px solid black">作者</td>
							<td style="border: 1px solid black">折扣</td>
							<td style="border: 1px solid black">价格</td>
							<td style="border: 1px solid black">数量</td>
							<td style="border: 1px solid black"></td>
							<td style="border: 1px solid black"></td>
						</tr>
						<%
						    request.setAttribute("service", BookService.getService());
						%>
						<c:forEach items="${service.list }" var="book">
							<tr>
								<td style="border: 1px solid black">${book.id }</td>
								<td style="border: 1px solid black">${book.name}</td>
								<td style="border: 1px solid black">${book.author }</td>
								<td style="border: 1px solid black">${book.discount }</td>
								<td style="border: 1px solid black">${book.price }</td>
								<td style="border: 1px solid black">${book.amount }</td>
								<td style="border: 1px solid black"><a
									href="BookDerailsServlet?id=${book.id}">详情</a></td>
								<td style="border: 1px solid black">
									<%-- <a href="BookDeleteServlet?id=${book.id }" >删除</a> --%> <a
									href="javascript:void(0)" onclick="del('${book.id}')">删除</a><br />
								</td>
							<tr>
								<br />
						</c:forEach>
					</table></td>
			</tr>

		</table>
		<center>
</body>
</html>
