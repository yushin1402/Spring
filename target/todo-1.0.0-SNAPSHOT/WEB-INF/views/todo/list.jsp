<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todo List</title>
<style type="text/css">
.strike {
    text-decoration: line-through;
}
</style>
</head>
<body>
    <h1>Todo List</h1>
    <div id="todoForm">
    	<t:messagesPanel />
    	<form:form
    		action="${pageContext.request.contextPath}/todo/create"
    		method="post" modelAttribute="todoForm">
    		<form:input path="todoTitle"/>
    		<form:errors path="todoTitle"/>
    		<form:button>Create Todo</form:button>
    	</form:form>
    </div>
    <hr />
    <div id="todoList">
        <ul>
            <!-- (1) -->
            <c:forEach items="${todos}" var="todo">
                <li><c:choose>
                        <c:when test="${todo.finished}"><!-- (2) -->
                            <span class="strike">
                            <!-- (3) -->
                            ${f:h(todo.todoTitle)}
                            </span>
                        </c:when>
                        <c:otherwise>
                            ${f:h(todo.todoTitle)}
                         </c:otherwise>
                    </c:choose></li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>