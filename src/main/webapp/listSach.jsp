<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2024
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh Sách Sách</h1>
<table border="1px solid">
    <tr>
        <th>Mã Sách</th>
        <th>Tên Sách</th>
        <th>Tác Giả</th>
        <th>Số Lượng</th>
        <th>Mô Tả</th>
        <th></th>
    </tr>
    <c:forEach items="${sach}" var="sach">
        <tr>
            <td>${sach.id}</td>
            <td>${sach.tenSach}</td>
            <td>${sach.tacGia}</td>
            <td>${sach.soLuong}</td>
            <td>${sach.moTa}</td>
            <td>
                <a href="Sach?action=muonSachForm" class="btn btn-info btn-sm me-2">Mượn Sách</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
