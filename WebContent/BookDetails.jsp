<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.oracle.book.service.BookService"%>
<%@page import="com.oracle.book.domain.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍库存登记系统</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
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

				<%
				    Book book=(Book)request.getAttribute("book");
				%>

				<td width="78%" valign="top" align="left"
					style="padding-left: 50px;"><br /> 书名：${book.name }<br />
				<br /> 类别： <c:forEach items="${book.type}" var="type">
						<c:if test='${type eq "S"}'>
                                科学
                            </c:if>
						<c:if test='${type eq "E"}'>
                                教育
                            </c:if>
						<c:if test='${type eq "W"}'>
                                文学
                            </c:if>
						<c:if test='${type eq "L"}'>
                                生活
                            </c:if>
						<c:if test='${type eq "O"}'>
                                其它
                            </c:if>
					</c:forEach> <br />
				<br> 作者：${book.author }<br />
				<br /> 折扣：${book.discount * 10 }折<br />
				<br /> 价格：${book.price }<br />
				<br /> 数量：${book.amount }<br />
				<br /> 简介：${book.profile }<br />
				<br /></td>
			</tr>
		</table>
		<center>
</body>
</html>
