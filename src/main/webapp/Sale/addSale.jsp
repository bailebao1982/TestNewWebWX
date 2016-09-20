<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>
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
        <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.0.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mobile-1.4.5.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mmenu.all.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/justgage/raphael-2.1.4.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/justgage/justgage.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/elycharts/elycharts.min.js"></script>
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
    </head>
    <body>
        <div id="page">
            <div class="header">
                <a href="#menu" class="contacts"></a><span>赫尔斯训练管理系统 添加销售记录</span>
            </div>
            <div>

                <form action="" class="mlogin" name="userForm">
                    <ul data-role="listview">

                        <li data-role="list-divider">销售信息</li>

                        <div class="field autoClear">
                            <div class="label">销售时间：</div>
                            <div class="field-control">
                                <input type="date" name = "saleTime" placeholder="销售时间" id="saleTime" value="${saleRec.salesTime}" data-clear-btn="true">
                            </div>
                        </div>

                        <div class="field autoClear">
                            <div class="label">课程开始时间：</div>
                            <div class="field-control">
                                <input type="date" name = "startTime" placeholder="课程开始时间" id="startTime" value="${saleRec.startDate}" data-clear-btn="true">
                            </div>
                        </div>

                        <div class="field autoClear">
                            <div class="label">课程结束时间：</div>
                            <div class="field-control">
                                <input type="date" name = "endTime" placeholder="课程结束时间" id="endTime" value="${saleRec.endDate}" data-clear-btn="true">
                            </div>
                        </div>

                        <div class="field autoClear">
                            <div class="label">单课价格:</div>
                            <div class="field-control">
                                <input type="text" class="input-required" name="unitPrice" placeholder="单课价格" id="unitPrice" value="${saleRec.unitPrice}" data-clear-btn="true">
                            </div>
                            <div class="label">元</div>
                        </div>
                            
                        <div class="field autoClear">
                            <div class="label">单课价格:</div>
                            <div class="field-control">
                                <input type="text" class="input-required" name="unitPrice" placeholder="单课价格" id="clssNum" value="${saleRec.classNum}" data-clear-btn="true">
                            </div>
                            <div class="label">元</div>
                        </div>    

                        <div class="field autoClear">
                            <div class="label">售课总价:</div>
                            <div class="field-control">
                                <input type="text" class="input-required" name="totalPrice" placeholder="售课总价" id="totalPrice" value="${saleRec.classNum*saleRec.unitPrice}" data-clear-btn="true">
                            </div>
                            <div class="label">元</div>
                        </div>

                        <div class="field autoClear">
                            <fieldset data-role="controlgroup" data-type="horizontal">
                                <div class="label">课程类型:</div>
                                <select name="classType" id="classType">
                                    <option value="mon">一对一私教</option>
                                    <option value="tue">一对多私教</option>
                                    <option value="tue">集体课</option>
                                </select>			
                            </fieldset>

                        </div>

                        <li data-role="list-divider">选择客户</li>
                        <div data-role="field autoClear">

                            <select name="day" id="day" multiple="multiple" data-native-menu="false">

                                <option>天</option>
                                <option value="mon">星期一</option>
                                <option value="tue">星期二</option>
                                <option value="wed">星期三</option>
                                <option value="thu">星期四</option>
                                <option value="fri">星期五</option>
                                <option value="sat">星期六</option>
                                <option value="sun">星期日</option>
                            </select>
                        </div>
                </ul>

                <div data-role="main" class="ui-content">
                    <input type="submit" data-inline="true" class="ui-btn ui-btn-inline ui-shadow" value="提交">
                    <input type="submit" data-inline="true" class="ui-btn ui-btn-inline ui-shadow" value="提交并增加销售记录">
                </div>	
            </form>		
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