<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />

        <title>赫尔斯训练管理系统</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mmenu.all.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mobile-1.4.5.min.css" />
        <link type="text/css" rel="stylesheet" href="https://g.alicdn.com/vip/login/0.5.23/css/mlogin.css">
        <link type="text/css" rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.0.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mobile-1.4.5.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mmenu.all.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/justgage/raphael-2.1.4.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/justgage/justgage.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/elycharts/elycharts.min.js"></script>

        <script type="text/javascript">
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

        </style>
    </head>
    <body>
        <div id="page">
            <div class="header">
                <a href="#menu" class="contacts"></a><span>赫尔斯训练管理系统</span>
            </div>
            <ul data-role="listview">

                <!--/div-->	
                <h4>销售信息</h4>
                <ul data-role="listview">
                    <li data-icon="edit"><a href="${pageContext.request.contextPath}/Sale/eidtSaleRecord?SaleRecordId=${saleRec.id}" rel="external"></a></li>	
                    <li>
                        <div class="field">
                            <div class="label">销售时间：</div>
                            <div class="label">${saleRec.salesTime}</div>
                        </div>
                    </li>
                    <li>
                        <div class="field">
                            <div class="label">课程开始时间：</div>
                            <div class="label">${saleRec.startDate}</div>
                        </div>
                    </li>
                    <li>
                        <div class="field">
                            <div class="label">课程结束时间：</div>
                            <div class="label"></div>
                        </div>
                    </li>
                    <li>
                        <div class="field">
                            <div class="label">单课价格:</div>
                            <div class="label">${saleRec.unitPrice}</div>
                            <div class="label">元</div>
                        </div>
                    </li>
                    <li>
                        <div class="field">
                            <div class="label">售课数量:</div>
                            <div class="label">${saleRec.classNum}</div>
                            <div class="label">节</div>
                        </div>
                    </li>
                    <li>
                        <div class="field">
                            <div class="label">售课总价:</div>
                            <div class="label">${saleRec.classNum*saleRec.unitPrice}</div>
                            <div class="label">元</div>
                        </div>
                    </li>
                    <li>
                        <div class="field">
                            <div class="label">课程类型:</div>
                            <div class="label">${saleRec.classType}</div>
                        </div>
                    </li>
                    <h4>客户信息</h4>
                    <li> 
                        <h2>总计购买次数：${totalSalesCls}</h2>
                        <p><b>总上课数：${totalUsedCls}</b></p>
                        <p>剩余课程数：${totalSalesCls-totalUsedCls}</p>


                    </li>

                </ul>

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