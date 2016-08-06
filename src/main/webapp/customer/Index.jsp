<%-- 
    Document   : Index
    Created on : 2016-6-23, 22:16:41
    Author     : wewezhu
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="../js/jquery-3.0.0.min.js"></script>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Insert title here</title>  
        <script type="text/javascript">
            function del(id) {
                $.get("/HealthyCorporationWXProject-1.0-SNAPSHOT/customer/delUser?id=" + id, function (data) {
                    if ("success" == data.result) {
                        alert("删除成功");
                        window.location.reload();
                    } else {
                        alert("删除失败");
                    }
                });
            }
        </script>  
    </head>
    <body>
        <h6><a href="/HealthyCorporationWXProject-1.0-SNAPSHOT/customer/toAddUser">添加用户</a></h6>  
        <table border="1">  
            <tbody>  
                <tr>  
                    <th>姓名</th>  
                    <th>年龄</th>  
                    <th>操作</th>  
                </tr>  
                <c:if test="${!empty userList }">  
                    <c:forEach items="${userList }" var="user">  
                        <tr>  
                            <td>${user.userName }</td>  
                            <td>${user.age }</td>  
                            <td>  
                                <a href="/HealthyCorporationWXProject-1.0-SNAPSHOT/customer/getUser?id=${user.id }">编辑</a>  
                                <a href="javascript:del('${user.id }')">删除</a>  
                            </td>  
                        </tr>               
                    </c:forEach>  
                </c:if>  
            </tbody>  
        </table>  
    </body>
</html>
