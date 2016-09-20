<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="author" content="www.frebsite.nl" />
        <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />

        <title>赫尔斯训练管理系统</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mmenu.all.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mobile-1.4.5.min.css" />
        <link type="text/css" rel="stylesheet" href="https://g.alicdn.com/vip/login/0.5.23/css/mlogin.css">
        <link type="text/css" rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" />
        <style type="text/css">
            .mm-menu li.img:after
            {
                left: 75px !important;
            }
            .mm-menu li.img a
            {
                font-size: 16px;
            }
            .mm-menu li.img a img
            {
                float: left;
                margin: -5px 10px -5px -5px;
                border-radius: 100px;
            }
            .mm-menu li.img a small
            {
                font-size: 12px;
            }

            .gauge {
                width: 250px;
                height: 250px;
                display: inline-block;
            }
        </style>
        <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.0.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mobile-1.4.5.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mmenu.all.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/justgage/raphael-2.1.4.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/justgage/justgage.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/elycharts/elycharts.min.js"></script>
        <script type="text/javascript">
            document.addEventListener("DOMContentLoaded", function (event) {

                var dflt = {
                    min: 0,
                    max: ${regClass},
                    donut: true,
                    gaugeWidthScale: 0.6,
                    counter: true,
                    hideInnerShadow: true
                }

                var gg2 = new JustGage({
                    id: 'gg2',
                    title: '课程数',
                    defaults: dflt
                });

            });

            $(function () {
                $("#menu")
                        .mmenu({
                            extensions: ["pageshadow", "theme-dark"],
                            dividers: {
                                add: true,
                                addTo: "[id*='contacts-']",
                                fixed: true
                            },
                            searchfield: {
                                resultsPanel: true
                            },
                            sectionIndexer: {
                                add: true,
                                addTo: "[id*='contacts-']"
                            },
                            navbar: {
                                title: ""
                            },
                            navbars: [{
                                    "position": "top",
                                    content: ["searchfield"]
                                },
                                {
                                    "position": "top"
                                },
                                {
                                    "position": "bottom",
                                    "content": [
                                        "<a class='fa fa-envelope' href='#/'></a>",
                                        "<a class='fa fa-twitter' href='#/'></a>",
                                        "<a class='fa fa-facebook' href='#/'></a>"
                                    ]
                                }
                            ]
                        }).on('click',
                        'a[href^="#/"]',
                        function () {
                            alert("Thank you for clicking, but that's a demo link.");
                            return false;
                        }
                );
            });
        </script>
    </head>
    <body>
        <div id="page">
            <div class="header">
                <a href="#menu" class="contacts"></a><span>赫尔斯训练管理系统</span>
            </div>
            <div>
                <div data-role="collapsible">
                    <h4>用户信息</h4>
                    <ul data-role="listview">
                        <li data-icon="edit"><a href="#">修改信息</a></li>				
                        <li>
                            <p>姓名：zhuwei</p>
                            <p>手机：144433344</p>
                            <p>微信id：wedadzzdddd</p>
                            <p>email:baddafd@sina.com</p>
                            <p>家庭住址: 苏州工业园区</p>
                            <p>职业：</p>
                        </li>
                    </ul>
                </div>

                <div data-role="collapsible">
                    <h4>售课信息</h4>
                    <ul data-role="listview">
                        <li data-icon="plus"><a href="/sale/addSale.html" rel="external">新增销售记录</a></li>
                            <c:if test="${!empty saleList }">  
                                <c:forEach items="${saleList }" var="saleRec">
                                <li data-role="list-divider">${saleRec.salesTime}<span class="ui-li-count">${saleRec.classNum}</span></li>   
                                <li><a href="${pageContext.request.contextPath}/Sale/viewSaleRecord?SaleRecordId=${saleRec.id}" rel="external">   
                                        <h2>教练：${saleRec.coacher}</h2>
                                        <br>
                                        <p><b>${saleRec.classType}</b></p>
                                        <p>目标：${saleRec.classType}</p>
                                    </a>
                                </li>
                            </c:forEach>  
                        </c:if>  

                        <li>
                            <div id="gg2" class="gauge" data-value="${regClass}"></div>

                        </li>		
                    </ul>
                </div>		
                <div data-role="collapsible">
                    <h4>体测信息</h4>
                    <ul data-role="listview">
                        <li data-icon="plus"><a href="/BM/addBM.jsp" rel="external">新增体侧记录</a></li>

                        <c:if test="${!empty bmList }">  
                            <c:forEach items="${bmList }" var="BM">  
                                <li data-role="list-divider"></li>   
                                <li><a href="/BM/viewBM.jsp?" rel="external">   
                                        <h2>纬度测试</h2>
                                        <p><b>测试人：</b></p>
                                        <p>上臂围度:  cm</p>
                                        <p>腿围度:  cm</p>
                                    </a>
                                </li>
                            </c:forEach>  
                        </c:if>  
                    </ul>
                </div>
            </div>

            <div data-role="collapsible">
                <h4>上课信息</h4>
                <div id="chart"></div>
                <script type="text/javascript">
                    $("#chart").chart({
                        type: "line",
                        labels: ["a", "b", "c", "d"],
                        tooltips: {
                            serie1: ["a", "b", "c", "d"],
                            serie2: ["a", "b", "c", "d"]
                        },
                        values: {
                            serie1: [70, 5, 93, 62],
                            serie2: [14, 47, 5, 70]
                        },
                        margins: [10, 10, 20, 50],
                        series: {
                            serie1: {
                                color: "red"
                            },
                            serie2: {
                                color: "blue"
                            }
                        },
                        defaultAxis: {
                            labels: true
                        },
                        features: {
                            grid: {
                                draw: true,
                                forceBorder: true
                            }
                        }
                    });
                </script>
            </div>
        </div>

        <nav id="menu">
            <ul>
                <li><span>客户管理</span>
                    <ul>
                        <li><span>客户信息</span>

                            <ul id="contacts-friends">
                                <c:if test="${!empty userList }">  
                                    <c:forEach items="${userList }" var="user">  
                                        <li class="img">
                                            <a href="/customer/userInfo.jsp?${user.id}" rel="external">
                                                <img src=/>
                                                <small>${user.name}</small>
                                            </a>
                                        </li>
                                    </c:forEach>  
                                </c:if>  
                            </ul>
                        </li>
                        <li><a href="#about/team"><span>添加新客户</span></a></li>
                        <li><a href="#about/address"><span>更新客户信息</span></a></li>
                    </ul>
                </li>
                <li><span>销售管理</span></a>
                    <ul>
                        <li><a href="#about/history">销售记录</a></li>
                        <li><a href="#about/team">新增销售信息</a></li>
                    </ul>
                </li>
                <li><span>上课管理</span></a>
                    <ul>
                        <li><a href="#about/history">签课记录</a></li>
                        <li><a href="#about/team">签课</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</body>
</html>