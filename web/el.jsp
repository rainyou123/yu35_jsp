<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/17
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("name","lisi");
        request.setAttribute("name","zhangsan");
        User user=new User();
        user.setName("zhaoliu");
        session.setAttribute("user",user);
        List<User> list=new ArrayList<>();
        list.add(user);
        User user1=new User();
        user1.setName("tianqi");
        list.add(user1);
        application.setAttribute("list",list);
    %>
    <%--从request域里取值--%>
    ${requestScope.name}<br/>
    <%--zhangsan--%>

    <%--从session域里取值--%>
    ${sessionScope.user.name}<br/>
    <%--zhaoliu--%>


    <%--从application域里取值--%>
    ${applicationScope.list[1].name}<br/>
    <%--tianqi--%>


    <%--从page域里取值--%>
    ${pageScope.name}<br/>
    <%--lisi--%>


    ${name}<br/>
    <%--lisi--%>

    ${pageContext.request.contextPath}<!--request.getContextPath()-->
    ${header["User-Agent"]}

    <br/>
    <%--$配合标签使用 --%>
    <c:forEach begin="0" end="5" var="i">
        <c:if test="${i==3}">
            ${i}
        </c:if>
        <c:if test="${i!=3}">
            ${i+1}
        </c:if>
        <%-- 1 2 3 3 5 6--%>
    </c:forEach>

    <br/>
    <%--在域里存着的list 想取只能用$--%>
    <%--items="数组或集合" var="数组或集合中的每一个元素"  varStatus="第多少个"--%>
    <c:forEach items="${list}" var="user" varStatus="vs">
        第${vs.count}个用户的名字为：${user.name}<br/>
    </c:forEach>
</body>
</html>
