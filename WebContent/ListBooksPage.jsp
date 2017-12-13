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
<script type="text/javascript">
	function changeCurrentPage(value){		
		location.href="ListBookByPageServlet?currentPage="+value;
	};
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
				<td width="78%" valign="top" align="left"><br />
					<table
						style="border: 1px solid black; cellspacing: 0; cellpadding: 0; margin: 0 auto; width: 600px;">
						<tr>
							<td style="border: 1px solid black">编号</td>
							<td style="border: 1px solid black">书名</td>
							<td style="border: 1px solid black">作者</td>
							<td style="border: 1px solid black">折扣</td>
							<td style="border: 1px solid black">价格</td>
							<td style="border: 1px solid black">数量</td>
							<td style="border: 1px solid black">详情信息</td>
							<td style="border: 1px solid black">删除</td>
						</tr>
						<%
						    request.setAttribute("service", BookService.getService());
						%>
						<c:forEach items="${pb.list }" var="book" varStatus="status">
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
		<center style="margin-left: 154px;">
			<a href="ListBookByPageServlet?currentNum=1">首页</a>&nbsp;&nbsp;

			<c:if test="${pb.currentNum == 1 }">
						上一页&nbsp;&nbsp;
					</c:if>
			<c:if test="${pb.currentNum != 1 }">
				<a href="ListBookByPageServlet?currentNum=${pb.currentNum-1 }">上一页</a>&nbsp;&nbsp;
					</c:if>

			<c:if test="${pb.currentNum == pb.totalPage }">
						下一页&nbsp;&nbsp;
					</c:if>
			<c:if test="${pb.currentNum != pb.totalPage }">
				<a href="ListBookByPageServlet?currentNum=${pb.currentNum+1 }">下一页</a>&nbsp;&nbsp;
					</c:if>

			<a href="ListBookByPageServlet?currentNum=${pb.totalPage }">尾页</a><br />
			<br />
		</center>
		<center>
			<center style="margin-left: 154px;">
				<select name="currentPage" onchange="changeCurrentPage(this.value);">
					<option>--请选择每页条数--</option>
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="20">20</option>
				</select>
			</center>
</body>
</html>






<%-- <jsp:useBean id="bookSvc" class="com.oracle.book.service.BookDAO" scope="page"></jsp:useBean> --%>
