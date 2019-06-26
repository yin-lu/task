<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/5/13
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<main>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${pageContext.request.contextPath}/statics/images/0d9944f1-6aad-4894-b42e-72dadcfef058.png" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/statics/images/a89456c6-c78c-45da-a766-e5945434ebab.png" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/statics/images/9c2b8d09-82ba-4e16-905d-ec7c7e9371ca.png" class="d-block w-100" alt="...">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <div class="container">
        <div class="row main-box"></div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-6 col-lg-3 small-big">
                <div class="col row justify-content-center">
                    <img src="${pageContext.request.contextPath}/statics/images/1.png" height="45" width="45">
                </div>
                <div class="main-one"></div>
                <div class="col row justify-content-center">
                    <h4>高效</h4>
                </div>
                <div class=" main-one"></div>
                <div class="col row justify-content-center">
                    <span class="text-one">将5年到7年的成长时间，缩短到一年到三年</span>
                </div>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3  small-big">
                <div class="col row justify-content-center">
                    <img src="${pageContext.request.contextPath}/statics/images/2.png" height="45" width="45">
                </div>
                <div class=" main-one"></div>
                <div class="col row justify-content-center">
                    <h4>规范</h4>
                </div>
                <div class=" main-one"></div>
                <div class="col row justify-content-center">
                    <span class="text-one">标准的实战教程，不会走弯路</span>
                </div>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3  small-big">
                <div class="col row justify-content-center">
                    <img src="${pageContext.request.contextPath}/statics/images/3.png" height="45" width="45">
                </div>
                <div class=" main-one"></div>
                <div class="col row justify-content-center">
                    <h4>人脉</h4>
                </div>
                <div class="main-one"></div>
                <div class="col row justify-content-center">
                    <span class="text-one">同班好友，同院学长，技术大师，入学就混到职脉圈子。</span>
                </div>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3 main-two d-flex align-items-center">
                <div class="col">
                    <div class="col row justify-content-center text-two">
                        <img src="${pageContext.request.contextPath}/statics/images/4.png">
                        <span> &ensp; ${total}</span>
                    </div>
                    <div class="col row justify-content-center">
                        <span>累计在线学习人数</span>
                    </div>
                    <div class="main-one "></div>
                    <div class="col row justify-content-center text-two">
                        <img src="${pageContext.request.contextPath}/statics/images/4.png">
                        <span> &ensp; ${graTotal}</span>
                    </div>
                    <div class="col row justify-content-center">
                        <span>毕业人数</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container text-ten">
        <div class="row text-center text-small">
            <div class="col">
                <span class="text-big">如何学习</span>
            </div>
        </div></div>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-6 col-lg-3 d-flex align-items-center justify-content-between small-pig">
                <div class="big-box">1</div>
                <span class="sp-box">匹配你现在的个人情况寻找适应自己的岗位</span>
                <img src="${pageContext.request.contextPath}/statics/images/5.png" width="32" height="30">
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3 d-flex align-items-center justify-content-between small-pig">
                <div class="big-box">2</div>
                <span class="sp-box">了解职业的前景薪金待遇竞争压力等</span>
                <img src="${pageContext.request.contextPath}/statics/images/5.png" width="32" height="30">
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3 d-flex align-items-center justify-content-between small-pig">
                <div class="big-box">3</div>
                <span class="sp-box">掌握行业内顶级技能</span>
                <img src="${pageContext.request.contextPath}/statics/images/5.png" width="32" height="30">
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3 d-flex align-items-center justify-content-between small-pig">
                <div class="big-box">4</div>
                <span class="sp-box">查看职业目标任务</span>
                <img src="${pageContext.request.contextPath}/statics/images/5.png" width="32" height="30">
            </div>
        </div>
        <div class="row box-io">
            <div class="col-sm-12 col-md-6 col-lg-3 d-flex align-items-center justify-content-between small-pig">
                <div class="big-box">5</div>
                <span class="sp-box">参考学习资源，掌握技能点，逐个完成任务</span>
                <img src="${pageContext.request.contextPath}/statics/images/5.png" width="32" height="30">
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3 d-flex align-items-center justify-content-between small-pig">
                <div class="big-box">6</div>
                <span class="sp-box">加入班级和小伙伴们互帮互助，一起学习</span>
                <img src="${pageContext.request.contextPath}/statics/images/5.png" width="32" height="30">
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3 d-flex align-items-center justify-content-between small-pig">
                <div class="big-box">7</div>
                <span class="sp-box">选择导师，一路引导，加速自己成长</span>
                <img src="${pageContext.request.contextPath}/statics/images/5.png" width="32" height="30">
            </div>
            <div class="col-sm-12 col-md-6 col-lg-3 d-flex align-items-center justify-content-between small-pig">
                <div class="big-box">8</div>
                <span class="sp-box">完成职业技能，升级业界大牛</span>
                <img src="${pageContext.request.contextPath}/statics/images/5.png" width="32" height="30">
            </div>
        </div>
    </div>
    <div class="container text-ten">
        <div class="row text-center text-small">
            <div class="col">
                <span class="text-big">优秀学员展示</span>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <c:forEach items="${graStudents}" var="graStudent">
            <div class="col-xl-3 col-sm-6">
                <div class="card">
                    <img class=" card-img-top rounded mx-auto d-block im-big" src="${pageContext.request.contextPath}${graStudent.image}" alt="Card image cap">
                    <div class="card-body">
                        <h6 class="card-title text-center">${graStudent.position}：${graStudent.name}</h6>
                        <p class="card-text text-one">${graStudent.intro}</p>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
    <div class="container">
        <div class="row  main-he">
            <div class="one"></div>
            <div class="one"></div>
            <div class="one"></div>
            <div class="one"></div>
        </div>
    </div>
    <div class="container text-ten">
        <div class="row text-center text-small">
            <div class="col">
                <span class="text-big">战略合作企业</span>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row wh-sm">
            <div class="col-sm-12 col-md-5 col-lg-2 d-flex justify-content-content wh-box">
                <div><img src="${pageContext.request.contextPath}/statics/images/01.png" width="160">
                </div>
            </div>
            <div class="col-sm-12 col-md-5 col-lg-2 d-flex justify-content-content wh-box ">
                <div><img src="${pageContext.request.contextPath}/statics/images/02.png" width="160">
                </div>
            </div>
            <div class="col-sm-12 col-md-5 col-lg-2 d-flex justify-content-content wh-box ">
                <div><img src="${pageContext.request.contextPath}/statics/images/03.png" width="150">
                </div>
            </div>
            <div class="col-sm-12 col-md-5 col-lg-2 d-flex justify-content-content wh-box ">
                <div ><img src="${pageContext.request.contextPath}/statics/images/04.png" width="150">
                </div>
            </div>
            <div class="col-sm-12 col-md-5 col-lg-2 d-flex justify-content-content wh-box ">
                <div ><img src="${pageContext.request.contextPath}/statics/images/05.png" width="150">
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row main-box"></div>
    </div>
    <div class="box-i">
        <div class="container">
            <div class="row box-id">
                <span>友情链接</span>
            </div>
        </div></div>
    <div class="box-i">
        <div class="container">
            <div class="row text">
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li >手机软件</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>教师招聘</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>找工作&emsp;</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>教师招聘</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>找工作&emsp;</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>手机软件</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>教师招聘</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>手机软件</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>手机软件</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>找工作&emsp;</li></span>
                </ul>
            </div>
            <div class="row text">
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>手机软件</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>教师招聘</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>找工作&emsp;</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>教师招聘</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>找工作&emsp;</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>手机软件</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>教师招聘</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>手机软件</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>手机软件</li></span>
                </ul>
                <ul class="col-sm-6 col-xl-1">
                    <span class="t-small"><li>找工作&emsp;</li></span>
                </ul>
            </div>
        </div>
    </div>
</main>