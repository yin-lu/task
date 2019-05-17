<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/4/29
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.text.SimpleDateFormat" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

<html>
<%--<div style="width:500px;margin:0px auto;text-align:center">--%>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>qq号</td>
        <td>修真类型</td>
        <td>入学时间</td>
        <td>毕业院校</td>
        <td>入门宣言</td>
        <td>师兄</td>
        <td>了解途径</td>
        <td>工作职位</td>
        <td>头像</td>
        <td>工作简介</td>
        <td>薪资</td>
        <td>是否结业</td>
        <td>创建时间</td>
        <td>更新时间</td>

    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.subject}</td>
            <td>${student.joinTime}</td>
            <td>${student.school}</td>
            <td>${student.wish}</td>
            <td>${student.instructor}</td>
            <td>${student.knowFrom}</td>
            <td>${student.position}</td>
            <td>${student.intro}</td>
            <td>${student.image}</td>
            <td>${student.salary}</td>
            <td>${student.graduation}</td>
            <td>${student.createAt}</td>
            <td>${student.updateAt}</td>
        </tr>
    </c:forEach>
</table>
<div style="text-align:center">
    <a href="/students">返回列表</a>
</div>
</body>
</html>
