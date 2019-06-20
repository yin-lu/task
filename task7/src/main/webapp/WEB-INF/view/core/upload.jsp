<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/6/13
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<form action="/u/details/{id}" method ="post" var="${user}">
    <input type="hidden" name="_method" value="PUT">
    <table align="center" border = "1px" bordercolor="#0000FF" width="400px" height="500" cellpadding="10" cellspacing="0">
        <%--<caption><center size="+2" color="#FF9966" >个人信息</center></caption>--%>
        <tbody>
        <tr>
            <th colspan="2" align="center" size="+2" color="#FF9966">
                <center>个人信息</center>
            </th>
        </tr >
        <tr>
            <th>ID:</th>
            <th><input type="text" name="id" value="${user.id}" id="id"/></th>
        </tr>
        <tr>
            <th>用户名:</th>
            <th><input type="text" name="name" value="${user.name}"/></th>
        </tr>
        <tr>
            <th>密码:</th>
            <th><input type="password" name="pwd" value="${user.pwd}"/></th>
        </tr>
        <tr>
            <th>手机:</th>
            <th><input type="text" name="phone" value="${user.phone}"/></th>
        </tr>
        <tr>
            <th>邮箱:</th>
            <th><input type="text" name="email" value="${user.email}"/></th>
        </tr>

            <th>头像</th>
            <th>
                <center><img src="${user.image}" width="100",height="100"></center>

           </th>
        </tr>
        <tr>
            <th colspan="2" align="center" >
                <center>
                <a href="/home">返回主页</a>
                <a href="/u/details/${user.id}">头像刷新</a>
                </center>
            </th>
        </tr >
        </tbody>
    </table>
</form>
<div>
   <center>
<form id="uploadForm" enctype="multipart/form-data">
    <input id="file" type="file" name="file"/>
    <br><br><br>
    <button id="upload" type="button" onclick="uploadImg()" >更改头像</button>
</form>
   </center>
</div>
<script>
    function uploadImg() {
        var  id=document.getElementById('id').value;
        var fromData = new FormData($('#uploadForm')[0]); // FormData 对象
        $.ajax({
            type: "post",
            url: '/u/upload/'+id,
            data:fromData,
            processData: false,
            contentType: false,
            success: function (data) {
                alert(data)
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }
</script>
</body>
</html>
