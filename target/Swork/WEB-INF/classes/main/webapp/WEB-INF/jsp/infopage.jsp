<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Person Cards Info</h1>
<div>
     <tr>
         <th>${personAttribute.firstName}</th>
         <th>${personAttribute.lastName}</th>
         <th>${personAttribute.money}</th>
     </tr>
</div>

<c:url var="addUrl" value="/trk/main/persons/${personAttribute.personId}/addcard" />
<table style="border: 1px solid; width: 500px; text-align:center">
    <thead style="background:#fcf">
    <tr>
        <th>Type</th>
        <th>Number</th>
        <th colspan="3"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${personAttribute.creditCards}" var="card">
        <c:url var="editUrl" value="/trk/main/persons/editcard?id=${personAttribute.personId}" />
        <c:url var="deleteUrl" value="/trk/main/persons/deletecard?id=${personAttribute.personId}" />


        <tr>
            <td><c:out value="${card.type}" /></td>
            <td><c:out value="${card.number}" /></td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
            <td><a href="${addUrl}">Add</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${empty personAttribute.creditCards}">
    There are currently no cards in the list. <a href="${addUrl}">Add</a> a card for person.
</c:if>

<c:url var="mainUrl" value="/trk/main/persons" />
<p>Return to <a href="${mainUrl}">Main List</a></p>

</body>
</html>