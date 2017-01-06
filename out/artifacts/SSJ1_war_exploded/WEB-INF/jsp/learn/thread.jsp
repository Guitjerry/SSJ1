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
    <title>学习中心</title>
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
                <div class="panel-heading">线程间通信(线程与线程间不是独立的个体，他们彼此之间可以相互通信)</div>
                <div class="panel-body">

                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>
