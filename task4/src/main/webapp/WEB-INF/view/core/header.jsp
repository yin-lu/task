<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/5/13
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<%--<html lang="en">--%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/task08.css">
</head>
<%--<body>--%>
<header>
    <div class="container">
        <div class="row">
            <div class="col head-box">
                <span class="text-success">客服热线：010-594-78634</span></div>
            <div class="head-box">
                <img src="${pageContext.request.contextPath}/statics/images/weixin1.png" class="img-fluid" alt="Responsive image">
                <img src="${pageContext.request.contextPath}/statics/images/qq1.png" class="img-fluid" alt="Responsive image">
                <img src="${pageContext.request.contextPath}/statics/images/dof%201.png" class="img-fluid" alt="Responsive image">
            </div>


        </div>
        <div class="row d-flex flex-row-reverse">
            <div class="text-box">
                <span class="text-success">登录丨注册</span>
            </div></div>
    </div>
    <div class="head-bot">
        <div class="container ">
            <nav class="navbar navbar-expand-lg navbar-light pho-img">
                <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/statics/images/task8.21.png" height="50px"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse text-bot" id="navbarNav" >
                    <ul class="navbar-nav ">
                        <li class="nav-item  ">
                            <a class="nav-link text-white " href="/home">首页</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white " href="/job">职业</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white " href="/recommend">推荐</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white " href="/students">学员</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</header>
