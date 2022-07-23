<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.me.domain.Product"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<HTML>
<head>
	<meta http-equiv="Content-Language" content="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript">
	//添加商品
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/login/home.jsp?item=product_add";
	}
	function deleteProduct() {
		window.location.href = "${pageContext.request.contextPath}/DelProductServlet";
	}
	</script>
   
</head>
<body>

	<br/>
	<form id="Form1" name="Form1" action="" method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<tr>
					<td align="center" bgColor="#afd1f3"><strong>查 询 条 件</strong></td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe">商品编号：</td>
								<td bgColor="#ffffff">
									<input type="text" name="id" size="15" value="" id="id" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe">类别：</td>
								<td  bgColor="#ffffff">
									<select name="category" id="category">
										<option value="" selected="selected">--选择商品类别--</option>
										<option value="文学">文学</option>
										<option value="生活">生活</option>
										<option value="计算机">计算机</option>
										<option value="外语">外语</option>
										<option value="经营">经营</option>
										<option value="励志">励志</option>
										<option value="社科">社科</option>
										<option value="学术">学术</option>
										<option value="少儿">少儿</option>
										<option value="艺术">艺术</option>
										<option value="原版">原版</option>
										<option value="科技">科技</option>
										<option value="考试">考试</option>
										<option value="生活百科">生活百科</option>
								</select></td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" >商品名称：</td>
								<td bgColor="#ffffff">
									<input type="text" name="name" size="15" value="" id="name" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" >价格区间(元)：</td>
								<td bgColor="#ffffff">
									<input type="text" name="minprice" size="10"/>
									-
									<input type="text" name="maxprice" size="10"/></td>
							</tr>
							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"></td>
								<td bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font></td>
								<td align="right" bgColor="#ffffff"><br /> <br /></td>
								<td align="right" bgColor="#ffffff">
									<button type="submit" id="search" name="search" value="查询">
										查询</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									<input type="reset" name="reset" value="重置" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#afd1f3"><strong>商 品 列 表</strong></TD>
				</tr>
				<tr>
					<td align="right">
						<button type="button" id="add" name="add" value="添加"
							 onclick="addProduct()">
							添加</button>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="24%">商品编号</td>
								<td align="center" width="18%">商品名称</td>
								<td align="center" width="9%">商品价格</td>
								<td align="center" width="9%">商品数量</td>
								<td width="8%" align="center">商品类别</td>
								<td width="8%" align="center">编辑</td>
								<td width="8%" align="center">删除</td>
							</tr>
							<!--  循环输出所有商品 -->

							<%--<c:forEach items="${ps}" var="product">--%>
							<c:forEach items="${pageHelp.list}" var="product">
							<%--<jsp:useBean id="product" class="com.me.domain.Product" scope="request"/>--%>
								<tr onmouseover="this.style.backgroundColor = 'white'"
												onmouseout="this.style.backgroundColor = '#fff663';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="200">
										${product.id}
										<%--<%=p.getId()%>--%>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">
										${product.name}
										<%--<%=p.getName()%>--%>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
										${product.price}
											<%--<%=p.getPrice()%>--%>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
										${product.pnum}
										<%--<%=p.getPnum()%>--%>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${product.category}
										<%--<%=p.getCategory()%>--%>
									</td>

									<!-- 编辑 -->
									<td align="center" style="HEIGHT: 22px" width="7%">
										<a href="${pageContext.request.contextPath}/FindById?id=${product.id}">
											<input type="button" style="color: #2fd529; font-weight: bold" value="✎"/>
											<%--<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand">--%>
										</a>
									</td>
									<!-- 删除 -->
									<td align="center" style="HEIGHT: 22px" width="7%">
										 <a href="${pageContext.request.contextPath}/DelProductServlet?id=${product.id}">
											 <input type="button" style="color: #FF0000; font-weight: bold" value="✖"/>
											 <%--<img src="${pageContext.request.contextPath}/admin/images/i_del.gif"
													 width="16" height="16" border="0" style="CURSOR: hand">--%>
										 </a>
									</td>
								</tr>
							</c:forEach>

						</table>
					</td>
				</tr>
		</table>

		<br/>
		<br/>
		<center>
			<%-- curPage 传递给servlet的参数，代表当前页，mysql从0开始计数 --%>
			<a href="FindProductServlet?curPage=0">首页</a>
			<a href="FindProductServlet?curPage=${pageHelp.currentPage-1}">上一页 </a>
			<a href="FindProductServlet?curPage=${pageHelp.currentPage+1}">下一页  </a>
			<a href="FindProductServlet?curPage=${pageHelp.totalPage-1}">尾页</a>
		</center>

	</form>
</body>
</HTML>