<%--
    类目管理
  Created by IntelliJ IDEA.
  User: dnys
  Date: 2016/11/17
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>商品类目管理</title>
</head>
<body>
<c:import url="../../common/include.jsp"></c:import>
<div class="container-fluid">
    <c:import url="../../common/header.jsp"></c:import>

    <div class="row">
        <c:import url="../../common/leftcommon.jsp"></c:import>
        <!--右侧内容-->
        <div class="col-md-9">
            <c:if test="${fn:length(categories)==0}">
                <div class="page-header">
                    <h3>当前还没有分类,请设置分类</h3>
                </div>

            </c:if>
            <div class="btn-group f-mt10">
                <button type="button" class="btn btn-info addmainbtn">新增分类</button>

            </div>
                     <c:if test="${fn:length(categories)>0}">
                         <table class="table table-striped">
                             <tr>
                                 <th>排序</th>
                                 <th>分类名</th>
                                 <th>状态</th>
                                 <th>操作</th>
                             </tr>
                             <tbody>
                                 <c:forEach items="${categories}" var="category">
                                     <tr>
                                         <td class="active">${category.sort}</td>
                                         <td class="active">${category.name}</td>
                                         <td class="active">
                                             <c:if test="${category.status==1}">
                                             有效
                                             </c:if>
                                             <c:if test="${category.status!=1}">
                                                 无效
                                             </c:if>
                                         </td>
                                         <td>
                                             <button type="button" class="btn btn-info editbtn" categoryid="${category.id}">编辑</button>
                                             <button type="button" class="btn btn-info addchildrenbtn" categoryid="${category.id}">增加子分类</button>
                                         </td>
                                     </tr>
                                 </c:forEach>
                             </tbody>
                         </table>
                     </c:if>



        </div>
    </div>




    <%--添加主分类--%>
    <div id="addcategory" class="f-none" style="width: 500px">
        <div class="f-title">新增分类</div>
        <form class="form-horizontal f-mt20" role="form"  id="categoryform">
            <div class="form-group">
                <label for="categorynname" class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="categorynname" placeholder="请输入姓名" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="categorysort" class="col-sm-2 control-label">排序</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="categorysort" placeholder="请输入排序"  name="sort">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-default btn-info " onclick="saveCategory()">保存</button>
                    <button type="button" class="btn btn-default btn-danger" onclick="closeSlidePanel()">关闭</button>
                </div>
            </div>
        </form>
    </div>


    <div id="editcategory" class="f-none" style="width: 500px"></div>
    <div id="addCategoryChildren" class="f-none" style="width: 500px"></div>
</div>


</body>
</html>
<script>

    //保存主分类
    function saveCategory() {
        $.ajax({
            type: "POST",
            url: "/SSJ/category/addCategory",
            data: $('#categoryform').serialize(),
            success: function(data){
                if(data.status=="success"){
                    var dataObj=eval("("+data+")")
                    toastrSuccessMessage(dataObj.msg,'信息提示');
                    closeSlidePanel();
                    location.reload();
                }
            }
        });
    }
    $(function () {
        $('.addchildrenbtn').on('click', function () {
            var categoryid = $(this).attr('categoryid');
            slidePanel('addCategoryChildren', '/SSJ/category/addCategoryChildren?categoryid='+categoryid, {
            })
        })
        $('.addmainbtn').on('click', function () {
            slidePanel('addcategory', '', {})
        })


        $('.editbtn').on('click', function () {
            var categoryid = $(this).attr('categoryid');
            slidePanel('editcategory', '/SSJ/category/editCategoryById?id=' + categoryid,{success:function () {
            }});

        })
    })

</script>