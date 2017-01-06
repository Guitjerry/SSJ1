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
    <title>新建待办事项</title>
    <c:import url="../common/include.jsp"></c:import>



</head>
<body>
<div class="container-fluid">
    <c:import url="../common/header.jsp"></c:import>

    <div class="row">
        <c:import url="../common/leftcommon.jsp"></c:import>
        <!--右侧内容-->
        <div class="col-md-9">

        </div>
    </div>

</div>

</body>
</html>
<script>


    $(function() {

//        var Accordion = function(el, multiple) {
//            this.el = el || {};
//            this.multiple = multiple || false;
//
//            // Variables privadas
//            var links = this.el.find('.link');
//            // Evento
//            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
//        }
//
//        Accordion.prototype.dropdown = function(e) {
//            var $el = e.data.el;
//            $this = $(this),
//                    $next = $this.next();
//
//            $next.slideToggle();
//            $this.parent().toggleClass('open');
//
//            if (!e.data.multiple) {
//                $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
//            };
//        }
//
//        var accordion = new Accordion($('#accordion'), false);
    });
</script>