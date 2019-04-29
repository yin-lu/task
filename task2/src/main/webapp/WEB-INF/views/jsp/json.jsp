<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/4/12
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${code}
<html>
<json:array name="students" var="student" items="${students}">
    <json:object>
        <json:property name="id" value="${student.id}"/>
        <json:property name="name" value="${student.name}"/>
        <json:property name="number" value="${student.number}"/>
        <json:property name="qq" value="${student.qq}"/>
        <json:property name="subject" value="${student.subject}"/>
        <json:property name="join_time" value="${student.joinTime}"/>
        <json:property name="school" value="${student.school}"/>
        <json:property name="wish" value="${student.wish}"/>
        <json:property name="instructor" value="${student.instructor}"/>
        <json:property name="know_from" value="${student.knowFrom}"/>
        <json:property name="create_at" value="${student.createAt}"/>
        <json:property name="update_at" value="${student.updateAt}"/>
    </json:object>
</json:array>
</html>
