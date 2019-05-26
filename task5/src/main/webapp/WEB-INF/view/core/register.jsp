<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/5/19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <tr>${error}</tr>
        <form action="/register" method="post">
            用户名： <input name="name" value="" type="text"> <br><br>
            密码: <input name="pwd" value="" type="password"> <br><br>
            手机号：<input name="phone" value="" type="text"> <br><br>
            邮箱：<input name="email" value="" type="text"> <br><br>
            <input type="submit" value="注册">
        </form>
    </div>
</div>
