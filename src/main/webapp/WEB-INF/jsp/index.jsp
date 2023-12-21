<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link type="text/css" rel="stylesheet" href="/css/style.css">
    <script type="text/javascript">let baseUrl = '${pageContext.request.contextPath}/'</script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
    <title>Список студентов</title>
</head>
<body>
<div class="layout">
    <div class="infobar">
        <h1>Список студентов</h1>
    </div>
    <div class="table-space">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Дата рождения</th>
                <th>Группа</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.surname}</td>
                    <td>${student.date}</td>
                    <td>${student.group}</td>
                    <td><button class="delete-button" data-student-id="${student.id}">Удалить</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="add-button-container">
            <button class="add-button">Добавить</button>
        </div>
        <div class="new-student-container" hidden>
            <button class="cancel-button">Отменить</button>
            <form class="student-form">
                <div class="input-container">
                    <label for="student-id">ID</label>
                    <input type="text" id="student-id" name="student[id]" required>
                </div>
                <div class="input-container">
                    <label for="student-name">Имя</label>
                    <input type="text" id="student-name" name="student[name]" required>
                </div>
                <div class="input-container">
                    <label for="student-surname">Фамилия</label>
                    <input type="text" id="student-surname" name="student[surname]" required>
                </div>
                <div class="input-container">
                    <label for="date">Дата рождения</label>
                    <input type="text" id="date" name="student[date]" required>
                </div>
                <div class="input-container">
                    <label for="group">Группа</label>
                    <input type="text" id="group" name="student[group]" required>
                </div>
            </form>
            <button class="create-button">Сохранить</button>
        </div>
    </div>
</div>
</body>
</html>