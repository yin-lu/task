<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/4/15
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width:500px;margin:0px auto;text-align:center">
<div style="text-align:center;margin-top:40px">
    <form action="/student" method="post">
        名字： <input name="name" value="" type="text"> <br><br>
        qq: <input name="qq" value="" type="text"> <br><br>
        修真类型：<input name="subject" value="" type="text"> <br><br>
        入学时间：<input name="joinTime" value="" type="text"> <br><br>
        毕业院校：<input name="school" value="" type="text"> <br><br>
        入学誓言：<input name="wish" value="" type="text"> <br><br>
        介绍人 ： <input name="instructor" value="" type="=text"> <br><br>
        了解渠道：<input name="knowFrom" value="" type="text"> <br><br>
        创建时间：<input name="createAt" value="" type="text"> <br><br>
        更新时间：<input name="updateAt" value="" type="text"> <br><br>
        <input type="submit" value="增加学员">
    </form>
</div>
</div>

