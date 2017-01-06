<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 16/12/18
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="w" uri="http://javacrazyer.iteye.com/tags/pager" %>
<html>
<head>
    <title>供货商列表</title>
</head>
<body>
<c:import url="../../common/include.jsp"></c:import>
<div class="container-fluid">
    <c:import url="../../common/header.jsp"></c:import>

    <div class="row">
        <c:import url="../../common/leftcommon.jsp"></c:import>
        <!--右侧内容-->
        <div class="col-md-9">
            <c:if test="${fn:length(supplierList)==0}">
                <div class="page-header">
                    <h3>当前还没有供货商,请添加供货商</h3>
                </div>

            </c:if>
            <div class="btn-group f-mt10">
                <button type="button" class="btn btn-info addmainbtn">新增供货商</button>

            </div>
            <c:if test="${fn:length(supplierList)>0}">
                <table class="table table-striped">
                    <tr>
                        <th>排序</th>
                        <th>名称</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    <tbody>
                    <c:forEach items="${supplierList}" var="supplier">
                        <tr>
                            <td class="active">${supplier.sort}</td>
                            <td class="active">${supplier.name}</td>
                            <td class="active">
                                <c:if test="${supplier.status==1}">
                                    有效
                                </c:if>
                                <c:if test="${supplier.status!=1}">
                                    无效
                                </c:if>
                            </td>
                            <td>
                                <button type="button" class="btn btn-info editbtn" supplierid="${supplier.id}">编辑</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
                <w:pager pageNo="${pageNo}" recordCount="${totalcount}" pageSize="${totalpage}" url="/SSJ/supplier/listSupplers"></w:pager>
            </c:if>


            <%--添加主分类--%>
            <div id="addsupplier" class="f-none" style="width: 500px">
                <div class="f-title">新增供货商</div>
                <form class="form-horizontal f-mt20" role="form"  id="addsupplierform">
                    <div class="form-group">
                        <label for="suppliernname" class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="suppliernname" placeholder="请输入姓名" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="suppliersort" class="col-sm-2 control-label">排序</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="suppliersort" placeholder="请输入排序"  name="sort">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default btn-info " onclick="saveSupplier()">保存</button>
                            <button type="button" class="btn btn-default btn-danger" onclick="closeSlidePanel()">关闭</button>
                        </div>
                    </div>
                </form>

            </div>





        </div>
    </div>

    <div id="editsupplier" style="width: 500px"></div>
</div>
</body>
</html>
<script>
    $(function () {
        $('.addmainbtn').on('click',function () {
            slidePanel('addsupplier');
        })
        $('.editbtn').on('click', function () {
            var supplierid = $(this).attr('supplierid');
            slidePanel('editsupplier', '/SSJ/supplier/editSupplierById?id=' + supplierid,{success:function () {
                
            }});
        })
    })
    function saveSupplier() {
        $.ajax({
            type: "POST",
            url: "/SSJ/supplier/addSupplier",
            data: $('#addsupplierform').serialize(),
            success: function(data){
                var dataObj=eval("("+data+")")
                if(dataObj.status=="success"){
                    toastrSuccessMessage(dataObj.msg,'信息提示');
                    setTimeout(function () {
                        closeSlidePanel();
                        location.reload();
                    },1000)

                }
            }
        });
    }
</script>