<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Create New Card for ${person.firstName} ${person.lastName}</h1>

<c:url var="saveUrl" value="/trk/main/persons/${person.personId}/addcard" />
<form:form modelAttribute="cardAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="type">Type:</form:label></td>
            <td><form:input path="type"/></td>
        </tr>

        <tr>
            <td><form:label path="number">Number:</form:label></td>
            <td><form:input path="number"/></td>
        </tr>


    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>