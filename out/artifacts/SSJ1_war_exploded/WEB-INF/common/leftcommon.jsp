<%--
  Created by IntelliJ IDEA.
  User: dnys
  Date: 2016/11/17
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>左侧导航</title>
</head>

<body>
<input id="msg" name="msg" value="${msg}" type="hidden">
<!--左侧菜单栏-->
<div class="col-md-3">
    <ul id="accordion" class="accordion">
        <li>
            <div class="link"><i class="glyphicon glyphicon-leaf"></i>商品模块<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#">发布新商品</a></li>
                <li><a href="#">仓库中</a></li>
                <li msg="category"><a href="/SSJ/category/list?msg=category">商品分类设置</a></li>
                <li msg="querysort"><a href="/SSJ/mls/listMlsSortGood?msg=querysort">美丽说排序查询</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="glyphicon glyphicon-credit-card"></i>交易管理<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#">订单管理</a></li>
                <li><a href="#">评价管理</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="glyphicon glyphicon-user"></i>客户管理<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#">客户管理</a></li>
                <li><a href="#">客户信息</a></li>

            </ul>
        </li>
        <li>
            <div class="link"><i class="glyphicon glyphicon-user"></i>供货信息<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li msg="supplier"><a href="/SSJ/supplier/listSupplers?msg=supplier">供货商管理</a></li>

            </ul>
        </li>

        <li>
            <div class="link"><i class="glyphicon glyphicon-user"></i>java学习中心<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li msg="java"><a href="/SSJ/learn/tool">集成工具</a></li>
            </ul>

            <ul class="submenu">
                <li msg="java"><a href="/SSJ/learn/thread">多线程</a></li>
            </ul>
            <ul class="submenu">
                <li msg="java"><a href="#">jmv调优</a></li>
            </ul>
            <ul class="submenu">
                <li msg="java"><a href="#">框架</a></li>
            </ul>
            <ul class="submenu">
                <li msg="redis"><a href="#">redis</a></li>
            </ul>
            <ul class="submenu">
                <li msg="redis"><a href="#">数据库</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="glyphicon glyphicon-user"></i>前端学习中心<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li msg="java"><a href="#">jquery</a></li>
            </ul>
            <ul class="submenu">
                <li msg="java"><a href="#">bootstarp</a></li>
            </ul>
            <ul class="submenu">
                <li msg="redis"><a href="#">组建开发</a></li>
            </ul>
        </li>
    </ul>
</div>
</body>
</html>
<script>
    $(function () {
        $('.submenu li').each(function () {
            if($(this).attr('msg')==$('#msg').val()){
                $(this).css('background-color','#4eb65c');
                $(this).parents('li').find('.submenu').css('display','block');
            }
        })

        $('#accordion .link').on('click',function (e) {
            $(this).parents('li').addClass('open').find('.submenu').slideDown('slow').css('display','block');

            $(this).parents('li').siblings('li').find('.link').removeClass('f-link').addClass('f-nolink');
            $(this).removeClass('f-nolink').addClass('f-link');
            $(this).parents('li').siblings('li').find('.submenu').slideUp('slow').css('display','none');
            // $(this).parents('li').slideUp().addClass('open');
        })
    })
</script>
