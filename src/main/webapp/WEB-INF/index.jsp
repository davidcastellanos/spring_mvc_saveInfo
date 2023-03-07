<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index - Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <header class="d-flex justify-content-between align-items-center">
        <h1>¡Save Travels!</h1>

    </header>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Expense</th>
        <th>Vendor</th>
        <th>Amount</th>
        <th>Actions</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${allExpenses}" var="expense">
        <tr>
            <td><a href="/expenses/${expense.id}" class=""><c:out value="${expense.expenseName}" /></a></td>
            <td><c:out value="${expense.vendor}" /></td>
            <td><c:out value="${expense.amount}" /></td>
            <td>
                <a href="/edit/${expense.id}" class="btn btn-warning">Editar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            </td>
            <td>
                <form action="/delete/${expense.id}" method="POST">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <input type="submit" value="Borrar" class="btn btn-danger"/>
                </form>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

    <header class="d-flex justify-content-between align-items-center">
        <h2>¡Add an Expense!</h2>

    </header>
    <div class="container">

        <form:form action="/expenses" method="POST" modelAttribute="formExpense">

            <div class="form-group">
                <form:label path="expenseName">Expense Name:</form:label>
                <form:input path="expenseName" class="form-control" />
                <form:errors path="expenseName" class="text-danger" />
            </div>

            <div class="form-group">
                <form:label path="vendor">Vendor:</form:label>
                <form:input path="vendor" class="form-control" />
                <form:errors path="vendor" class="text-danger" />
            </div>

            <div class="form-group">
                <form:label path="amount">Amount:</form:label>
                <form:input path="amount" class="form-control" />
                <form:errors path="amount" class="text-danger" />
            </div>

            <div class="form-group">
                <form:label path="description">Description:</form:label>
                <form:input path="description" class="form-control" />
                <form:errors path="description" class="text-danger" />
            </div>
            <br>
            <input type="submit" value="Guardar" class="btn btn-success" />
        </form:form>

    </div>
</div>
</body>
</html>