<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.oracle.book.service.BookService"%>
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
				<td width="78%" valign="top" align="left"><br />
					<h3>&nbsp;&nbsp;书籍入库成功</h3>
					<ul>
						<li>${book.name}书籍入库成功！</li>
						<br />
					</ul></td>
			</tr>
		</table>
		<center>
</body>
</html>
