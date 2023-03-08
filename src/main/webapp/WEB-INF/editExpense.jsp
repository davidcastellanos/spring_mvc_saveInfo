<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Expense</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">

        <header class="d-flex justify-content-between align-items-center">
            <h1>Edit Expense</h1>

        </header>

        <form:form action="/edit/${expenseAEditar.id}" method="POST" modelAttribute="expenseAEditar">

            <input type="hidden" name="_method" value="put"/>
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

</body>
</html>