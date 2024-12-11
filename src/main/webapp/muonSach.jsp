<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2024
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo Mới Sách</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        input, select {
            margin: 10px 0;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 18px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        select[multiple] {
            height: 150px;
            resize: vertical;
        }
        .form-group {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Tạo Mới Sách</h1>
    <form method="post" action="muonSachForm">
        <div class="form-group">
            <input type="text" name="maMuonSach" placeholder="Mã Mượn Sách" required>
        </div>
        <div class="form-group">
            <input type="text" name="author" placeholder="Mã Sách ID" required>
        </div>
        <div class="form-group">
            <select name="hocSinh" id="hocSinh" multiple required>
                <c:forEach items="${hocSinh}" var="hocSinh">
                    <option value="${hocSinh.id}">${hocSinh.hoTen}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <input type="text" name="description" placeholder="Trạng Thái" required>
        </div>
        <div class="form-group">
            <input type="date" name="ngayMuon" placeholder="Ngày Mượn" required>
        </div>
        <div class="form-group">
            <input type="date" name="ngayTra" placeholder="Ngày Trả" required>
        </div>
        <div class="form-group">
            <input type="submit" value="Tạo Mới">
        </div>
    </form>
</div>
</body>
</html>

