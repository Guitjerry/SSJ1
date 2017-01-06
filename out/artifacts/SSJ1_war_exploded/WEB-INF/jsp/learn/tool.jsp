<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <title>工具</title>
    <c:import url="../../common/include.jsp"></c:import>



</head>
<body>
<div class="container-fluid">
    <c:import url="../../common/header.jsp"></c:import>

    <div class="row">
        <c:import url="../../common/leftcommon.jsp"></c:import>
        <!--右侧内容-->
        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">如何写一个分页插件</div>
                <div class="panel-body">
                    1.编写前端分页标签   <br>
                        定义标签类 PagerTag<br>
                        定义tld规则 pager.tld <br>
                    2.定义后台分页类规则<br>
                         定义分页bean  PageBean
                    3.请求里根据参数关联


                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">ngnix与tomcat的集成</div>
                <div class="panel-body">

                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>
