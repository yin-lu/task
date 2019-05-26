<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/5/13
  Time: 11:20
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/task8.css">
</head>
<main>
    <div>
        <img  class="ihp-one" src="${pageContext.request.contextPath}/statics/images/task08-tuijian.png">
    </div>
    <div class="container">
        <div class="row text-one">
            <div class="col">
                <span>首页></span>
                <span class="text-z">推荐</span>
            </div>
        </div>

        <div class="row text-nim">
            <div class="col-sm-12 col- md-6 col-lg-3 m-zero">
                <div class="col text-center m-one">
                    <h4>合作企业</h4>
                </div>
                <div class="col d-flex justify-content-center d-m">
                    <ul class="list-style-type-none  text-m">
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">阿里巴巴</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">腾讯视频</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">土豆网</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">背景葡萄藤</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">阿里巴巴</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">阿里巴巴</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">腾讯视频</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">土豆网</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">背景葡萄藤</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">阿里巴巴</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">背景葡萄藤</a></li>
                        <li class="d-flex align-items-center text-p">
                            <div class="item-three"></div>
                            <a href class="d-box">阿里巴巴</a></li>
                    </ul>
                </div>
            </div>
            <div class="col -lg-1 main-kong"></div>
            <div class="col-sm-12 col-md-6 col-lg-8 m-zer">
                <div class="row main-1">
                    <div class="col-sm-4 d-flex justify-content-center align-items-center">
                        <img src="${pageContext.request.contextPath}/statics/images/tudou.psb.png">
                    </div>
                    <div class="col-sm-7">
                        <span class="text-small">土豆网公司成立于1998年11月，
                            是目前中国最大的互联网综合服务提供商之一，也是中国
                            服务用户最多的互联网企业之一。成立10多年以来，
                            腾讯一直秉承一切以用户价值为依归的经营理念，始终处于稳健、
                            高速发展的状态。2004年6月16日，腾讯公司在香港联交所主板
                            公开上市（股票代号700）。</span>
                    </div>
                </div>
                <div class="col main-2">
                    <p>&emsp;&emsp;土豆是中国最早和最具影响力的网络视频平台，是中国网络视频行业的
                        领军品牌。其前身土豆网于2005年4月15日正式上线，是全球最早上线
                        的视频网站之一。2014年1月，“土豆网”正式更名为“土豆”，标志
                        着土豆进入品牌发展的新阶段。</p>
                </div>
                <div class="col main-2">
                    <span>&emsp;&emsp;“每个人都是生活的导演”是土豆从创立第一天始的价值观。土豆
                        相信年轻人的想象力、创造力，相信土豆的平台能帮助年轻人创造出更多，
                        更好的影像作品，来表达对自己、生活和这个时代的看法。同时，土豆提
                        倡尊重“每个人”的个性，尊重每个人自主地选择自己的生活，
                        成为自己成长的导演。</span></div>
                <div class="col main-2">
                    <span> &emsp;&emsp;2012年3月12日，优酷股份有限公司(NYSE: YOKU) (“优酷”)
                        和土豆股份有限公司 (NASDAQ: TUDO) (“土豆”)共同宣布，
                        优酷和土豆将以100%换股的方式合并。2012年8月20日，
                        优酷土豆合并方案获双方股东大会高票批准通过，优酷土豆集团公司正式诞生。
                        2013年4月，优酷土豆集团宣布进入“集团BU化”运营阶段，提出“优酷更优酷，
                        土豆更土豆”的发展战略。</span></div>
                <div class="col main-2">
                    <span>&emsp;&emsp; 2013年2月，杨伟东成为土豆总裁，宣布打造土豆“成为中国年轻人最喜爱的
                        视频网站”，并明确土豆“成为中国最具影响力的青年文化品牌”的愿景，
                        确立了土豆“青春、个性、自主、有趣”的品牌定位，土豆全面进入2.0阶段。
                        通过年轻化的内容、年轻化的产品技术和年轻化的UGC/PGC生态三个方面来全面
                        推动土豆2.0战略。</span></div>
                <div class="col main-2">
                <span>&emsp;&emsp;2014年3月土豆推出“4+1”战略。其中“4”代表的是土豆在内容方面更专注动漫、
                    音乐、韩国娱乐、时尚四个垂直文化领域。而“1”则代表土豆推出的“一个频道”战略，
                    基于“频道主”和“订阅者”两个视角全方位架构跨屏和线上线下体验系统，并结合用户体验、
                    商业模式、运营机制等环节，提出了5个“一”规划。</span></div>
                <div class="col main-2">
                    <span> &emsp;&emsp;根据第三方调研公司艾瑞的数据，优酷土豆集团在PC端和移动端全平台各项数据持续占据视
                 频行业绝对领先优势，截止2014年3月，土豆每月独立访问用户数量增长到2.43亿。 2013年土豆
                 在移动端的增长也非常迅猛，2013年三季度，土豆移动端获得了高速增长，月均覆盖用户较当年3月
                 增长11倍，平均增长率超过40%；月均视频播放量增长23倍，月平均增幅达60%。</span>
                </div>
            </div>
        </div>
        <div class="row box-big"></div>
    </div>
</main>