<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>login</title>
</head>

<div  style="display: flex; justify-content:space-around;align-content: center;width: 100%">
    <div style=" margin-top: 142px;">
        <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png"/>
    </div>
<form action="${pageContext.request.contextPath}/login" method="POST" >
    <table>
        <tr>
            <td>用户名:</td>
            <td><input name="name" value="" type="text"></td>
        </tr>
        ${error}
        <tr>
            <td>密码:</td>
            <td><input name="pwd" value="" type="password"></td>
        </tr>
        <tr >
            <td><input type="submit" value="登录"  ></td>
            <td><input type="button" value="注册" onclick="window.location.href='/register'"> </td>
        </tr>
    </table>
</form>
</td>
</table>
    </div>
</html>