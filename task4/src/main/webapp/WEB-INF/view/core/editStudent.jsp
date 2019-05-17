<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/4/8
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width:500px;margin:0px auto;text-align:center">


    <div style="text-align:center;margin-top:40px">

        <form method="post" action="../students/${student.id}">
            <input type="hidden" name="_method" value="PUT">
            名字： <input name="name" value="${student.name}" type="text"><br><br>
            qq:<input name="qq" value="${student.qq}" type="text"> <br><br>
            修真类型：<input name="subject" value="${student.subject}" type="text"> <br><br>
            入学时间：<input name="joinTime" value="${student.joinTime}" type="text"> <br><br>
            毕业院校：<input name="school" value="${student.school}" type="text"> <br><br>
            入门誓言：<input name="wish" value="${student.wish}" type="text"> <br><br>
            介绍人：<input name="instructor" value="${student.instructor}" type="text"><br><br>
            了解渠道：<input name="knowFrom" value="${student.knowFrom}" type="text"> <br><br>
            工作职位：<input name="position" value="${student.position}" type="text"><br><br>
            工作简介：<input name="intro" value="${student.intro}" type="text"><br><br>
            头像：<input name="image" value="${student.image}" type="text"><br><br>
            薪资：<input name="salary" value="${student.salary}" type="text"><br><br>
            是否结业：<input name="graduation" value="${student.graduation}" type="text"><br><br>
            创建时间：<input name="createAt" value="${student.createAt}" type="text"> <br><br>
            更新时间：<input name="updateAt" value="${student.updateAt}" type="text"> <br><br>
            <input type="submit" value="更改">
        </form>

    </div>
</div>
