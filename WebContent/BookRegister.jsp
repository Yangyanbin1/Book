<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.oracle.book.service.BookService"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍库存登记系统</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#button {
	margin-left: -50px;
	margin-right: 35px;
}
</style>
</head>
<body>
	<center>
		<table width="80%" border="1" cellpadding="0" cellspacing="0"
			bordercolor="#FF0000">
			<tr>
				<td colspan="2"><img src="images/banner.png" alt="书籍库存登记系统"
					width="100%" /></td>
			</tr>
			<tr>
				<td width="22%" height="480" valign="top"
					background="images/bg_left.png"><br />
				<br />
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
				<td width="78%" valign="top" align="left"><br /> <c:if
						test="${not empty errors}">
						<font color="red">
							<ul>
								<c:forEach items="${errors}" var="error">
									<li>${error}</li>
									<br />
								</c:forEach>
							</ul>
						</font>
					</c:if>
					<form action="BookRegisterServlet" method="post" style="padding-left: 60px;">
						书名： <input type="text" name="name" style="width: 300px"><br />
						<br /> 类别： <input type="checkbox" name="type" value="S">科学
						<input type="checkbox" name="type" value="E">教育 <input
							type="checkbox" name="type" value="W">文学 <input
							type="checkbox" name="type" value="L">生活 <input
							type="checkbox" name="type" value="O">其它<br />
						<br /> 作者： <input type="text" name="author" style="width: 300px"><br />
						<br /> 折扣： <input type="radio" name="discount" value="1.0" checked>全价
						<input type="radio" name="discount" value="0.9">九折 <input
							type="radio" name="discount" value="0.8">八折 <input
							type="radio" name="discount" value="0.7">七折 <input
							type="radio" name="discount" value="0.6">六折<br />
						<br /> 价格： <input type="text" name="price" /><br />
						<br /> 数量： <input type="text" name="amount" /><br />
						<br /> 简介：
						<textarea name="profile" rows="3" cols="35" style="resize: none"></textarea>
						<br />
						<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
							name="submit" value="登记" style="width: 80px; height: 30px"
							id="button"> <input type="reset" name="concel"
							value="取消" style="width: 80px; height: 30px">
					</form></td>
			</tr>
		</table>
		<center>
</body>
</html>
