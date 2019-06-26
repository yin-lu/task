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
<%@ taglib uri="/tags" prefix="date"%>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/task008.css">
</head>

<main>
    <div class="container">
        <div class="row text-one">
            <div class="col">
                <span>首页></span>
                <span class="text-z">职业</span>
            </div>
        </div>
        <div class="row text-text">
            <div class="col">
                <span >方向:</span>
                <a href="#" class="text-f" >全部</a>
                <a href="#fff" class="text-f">前端开发</a>
                <a href="#ddd" class="text-f">后端开发</a>
                <a href="#" class="text-f">移动开发</a>
                <a href="#" class="text-f">整站开发</a>
                <a href="#" class="text-f">运营维护</a>
            </div>
        </div>
        <div class="row text-two">
            <div class="col">
                <span class="text-q" id="fff">前端开发选项</span>
            </div>
        </div>
        <div class="row main-box">
        </div>
        <div class="row">
           <c:forEach items="${jobs}" var="job">
               <c:if test="${job.direction == '前端开发'}">
            <div class="col-md-6 col-sm-12 col-lg-4 box-com ">
                <div class="wrapper">
                    <div class="item-one ">
                    </div>
                    <div class="item-two">
                        <h6>${job.name}</h6>
                        <p>${job.intro}</p>
                    </div>
                    <div class="item-three">
                        <span class="i-h">门槛</span>
                        <c:forEach begin="1" end="${job.door}">
                        <img  class="i-t" src="${pageContext.request.contextPath}/statics/images/11.png">
                        </c:forEach>
                    </div>
                    <div class="item-four">
                        <span class="i-h">难易程度</span>
                        <c:forEach begin="1" end="${job.complexity}">
                        <img  class="i-t" src="${pageContext.request.contextPath}/statics/images/11.png">
                        </c:forEach>
                    </div>
                    <div class="item-five">
                        <span class="i-h">成长周期</span>
                        <span class="i-f">${job.cycle}</span>
                        <span class="i-i">年</span>
                    </div>
                    <div class="item-six">
                        <span class="i-h">稀缺程度</span>
                        <span class="i-f">${job.scarcity}</span>
                        <span class="i-i">家公司需要</span>
                    </div>
                    <div class="item-seven">
                        <span class="i-i">薪资待遇</span>
                    </div>
                    <div class="item-nth">
                        <span class="i-n">0-1年</span>
                        <span class="i-1">${job.one}</span>
                    </div>
                    <div class="item-n">
                        <span class="i-n">1-2年</span>
                        <span class="i-1">${job.two}</span>
                    </div>
                    <div class="item-t">
                        <span class="i-n">2-3年</span>
                        <span class="i-1">${job.three}</span>
                    </div>
                    <div class="item-ten">
                        <span>有</span>
                        <span class="i-2">${job.number}</span>
                        <span>人正在学</span>
                    </div>
                    <div class="item-zero">
                        <span>提示:${job.hint}</span>
                    </div>
                    <div class="item-zero">
                        <span>更新时间：<date:date value="${job.updateAt}"/></span>
                    </div>
                    <div class="text-no">
                        <h4>${job.name}</h4>
                        <div class="text-1">
                        <span>${job.intro}</span></div>
                    </div>
                </div>
            </div>
               </c:if>
           </c:forEach>
        </div>

        <div class="row text-two">
            <div class="col">
                <span class="text-q" id="ddd">后端开发选项</span>
            </div>
        </div>
        <div class="row main-box">
        </div>
        <div class="row">
            <c:forEach items="${jobs}" var="job">
                <c:if test="${job.direction == '后端开发'}">
                    <div class="col-md-6 col-sm-12 col-lg-4 box-com ">
                        <div class="wrapper">
                            <div class="item-one ">
                            </div>
                            <div class="item-two">
                                <h6>${job.name}</h6>
                                <p>${job.intro}</p>
                            </div>
                            <div class="item-three">
                                <span class="i-h">门槛</span>
                                <c:forEach begin="1" end="${job.door}">
                                    <img  class="i-t" src="${pageContext.request.contextPath}/statics/images/11.png">
                                </c:forEach>
                            </div>
                            <div class="item-four">
                                <span class="i-h">难易程度</span>
                                <c:forEach begin="1" end="${job.complexity}">
                                    <img  class="i-t" src="${pageContext.request.contextPath}/statics/images/11.png">
                                </c:forEach>
                            </div>
                            <div class="item-five">
                                <span class="i-h">成长周期</span>
                                <span class="i-f">${job.cycle}</span>
                                <span class="i-i">年</span>
                            </div>
                            <div class="item-six">
                                <span class="i-h">稀缺程度</span>
                                <span class="i-f">${job.scarcity}</span>
                                <span class="i-i">家公司需要</span>
                            </div>
                            <div class="item-seven">
                                <span class="i-i">薪资待遇</span>
                            </div>
                            <div class="item-nth">
                                <span class="i-n">0-1年</span>
                                <span class="i-1">${job.one}</span>
                            </div>
                            <div class="item-n">
                                <span class="i-n">1-2年</span>
                                <span class="i-1">${job.two}</span>
                            </div>
                            <div class="item-t">
                                <span class="i-n">2-3年</span>
                                <span class="i-1">${job.three}</span>
                            </div>
                            <div class="item-ten">
                                <span>有</span>
                                <span class="i-2">${job.number}</span>
                                <span>人正在学</span>
                            </div>
                            <div class="item-zero">
                                <span>提示:${job.hint}</span>
                            </div>
                            <div class="item-zero">
                                <span>更新时间：<date:date value="${job.updateAt}"/></span>
                            </div>
                            <div class="text-no">
                                <h4>${job.name}</h4>
                                <div class="text-1">
                                    <span>${job.intro}</span></div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="row text-two">
            <div class="col">
                <span class="text-q">运维方向</span>
            </div>
        </div>
        <div class="row main-box">
        </div>
        <div class="row">
            <c:forEach items="${jobs}" var="job">
                <c:if test="${job.direction == '运维方向'}">
                    <div class="col-md-6 col-sm-12 col-lg-4 box-com ">
                        <div class="wrapper">
                            <div class="item-one ">
                            </div>
                            <div class="item-two">
                                <h6>${job.name}</h6>
                                <p>${job.intro}</p>
                            </div>
                            <div class="item-three">
                                <span class="i-h">门槛</span>
                                <c:forEach begin="1" end="${job.door}">
                                    <img  class="i-t" src="${pageContext.request.contextPath}/statics/images/11.png">
                                </c:forEach>
                            </div>
                            <div class="item-four">
                                <span class="i-h">难易程度</span>
                                <c:forEach begin="1" end="${job.complexity}">
                                    <img  class="i-t" src="${pageContext.request.contextPath}/statics/images/11.png">
                                </c:forEach>
                            </div>
                            <div class="item-five">
                                <span class="i-h">成长周期</span>
                                <span class="i-f">${job.cycle}</span>
                                <span class="i-i">年</span>
                            </div>
                            <div class="item-six">
                                <span class="i-h">稀缺程度</span>
                                <span class="i-f">${job.scarcity}</span>
                                <span class="i-i">家公司需要</span>
                            </div>
                            <div class="item-seven">
                                <span class="i-i">薪资待遇</span>
                            </div>
                            <div class="item-nth">
                                <span class="i-n">0-1年</span>
                                <span class="i-1">${job.one}</span>
                            </div>
                            <div class="item-n">
                                <span class="i-n">1-2年</span>
                                <span class="i-1">${job.two}</span>
                            </div>
                            <div class="item-t">
                                <span class="i-n">2-3年</span>
                                <span class="i-1">${job.three}</span>
                            </div>
                            <div class="item-ten">
                                <span>有</span>
                                <span class="i-2">${job.number}</span>
                                <span>人正在学</span>
                            </div>
                            <div class="item-zero">
                                <span>提示:${job.hint}</span>
                            </div>
                            <div class="item-zero">
                                <span>更新时间：<date:date value="${job.updateAt}"/></span>
                            </div>
                            <div class="text-no">
                                <h4>${job.name}</h4>
                                <div class="text-1">
                                    <span>${job.intro}</span></div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="row text-two">
            <div class="col">
                <span class="text-q">移动开发</span>
            </div>
        </div>
        <div class="row main-box">
        </div>
        <div class="row">
            <c:forEach items="${jobs}" var="job">
                <c:if test="${job.direction == '移动开发'}">
                    <div class="col-md-6 col-sm-12 col-lg-4 box-com ">
                        <div class="wrapper">
                            <div class="item-one ">
                            </div>
                            <div class="item-two">
                                <h6>${job.name}</h6>
                                <p>${job.intro}</p>
                            </div>
                            <div class="item-three">
                                <span class="i-h">门槛</span>
                                <c:forEach begin="1" end="${job.door}">
                                    <img  class="i-t" src="${pageContext.request.contextPath}/statics/images/11.png">
                                </c:forEach>
                            </div>
                            <div class="item-four">
                                <span class="i-h">难易程度</span>
                                <c:forEach begin="1" end="${job.complexity}">
                                    <img  class="i-t" src="${pageContext.request.contextPath}/statics/images/11.png">
                                </c:forEach>
                            </div>
                            <div class="item-five">
                                <span class="i-h">成长周期</span>
                                <span class="i-f">${job.cycle}</span>
                                <span class="i-i">年</span>
                            </div>
                            <div class="item-six">
                                <span class="i-h">稀缺程度</span>
                                <span class="i-f">${job.scarcity}</span>
                                <span class="i-i">家公司需要</span>
                            </div>
                            <div class="item-seven">
                                <span class="i-i">薪资待遇</span>
                            </div>
                            <div class="item-nth">
                                <span class="i-n">0-1年</span>
                                <span class="i-1">${job.one}</span>
                            </div>
                            <div class="item-n">
                                <span class="i-n">1-2年</span>
                                <span class="i-1">${job.two}</span>
                            </div>
                            <div class="item-t">
                                <span class="i-n">2-3年</span>
                                <span class="i-1">${job.three}</span>
                            </div>
                            <div class="item-ten">
                                <span>有</span>
                                <span class="i-2">${job.number}</span>
                                <span>人正在学</span>
                            </div>
                            <div class="item-zero">
                                <span>提示:${job.hint}</span>
                            </div>
                            <div class="item-zero">
                                <span>更新时间：<date:date value="${job.updateAt}"/></span>
                            </div>
                            <div class="text-no">
                                <h4>${job.name}</h4>
                                <div class="text-1">
                                    <span>${job.intro}</span></div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="row main-box">
        </div>
    </div>
</main>