<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expense Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
<header class="d-flex justify-content-between align-items-center">
        <h1>Expense Details</h1>
        <a href="/expenses" class="btn btn-info">Volver al inicio</a>
</header>
<table class="table">
    <tbody>
    <tr>
        <th>Expense</th>
        <th>Vendor</th>
        <th>Amount</th>
        <th>Description</th>
    </tr>

    <tr>
        <td><c:out value="${expense.expenseName}" /></td>
        <td><c:out value="${expense.vendor}" /></td>
        <td><c:out value="${expense.amount}" /></td>
        <td><c:out value="${expense.description}" /></td>
    </tr>

    </tbody>
</table>
</div>
</body>
</html>