<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 17/1/2
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑供货商</title>
</head>
<div class="f-title">编辑供货商</div>
<body>
        <form class="form-horizontal f-mt20" role="form"  id="editsupplierform">
            <div class="form-group">
                <label for="editsuppliernname" class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="editsuppliernname" placeholder="请输入姓名" name="name" value="${supplier.name}">
                </div>
            </div>
            <div class="form-group">
                <label for="editsuppliersort" class="col-sm-2 control-label">排序</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="editsuppliersort" placeholder="请输入排序"  name="sort" value="${supplier.sort}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-default btn-info " onclick="updateSupplier(${supplier.id})">保存</button>
                    <button type="button" class="btn btn-default btn-danger" onclick="closeSlidePanel()">关闭</button>
                </div>
            </div>
        </form>
</body>
</html>
<script>
    function updateSupplier(id) {
        $.ajax({
            type: "POST",
            url: "/SSJ/supplier/editSupplier?id="+id,
            data: $('#editsupplierform').serialize(),
            success: function(data){
                var dataObj=eval("("+data+")")
                if(dataObj.status=="success"){
                    toastrSuccessMessage(dataObj.msg,'信息提示');
                    closeSlidePanel();
                    setTimeout(function () {
                        location.reload();
                    },1000)
                }
            }
        });
    }
</script>
