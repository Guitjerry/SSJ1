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
            <c:if test="${fn:length(mls_sortgoodList)==0}">
                <div class="page-header f-mt10">
                    <h3>当前还没有商品配置,请配置</h3>
                </div>

            </c:if>
            <div class="btn-group f-mt10">
                <button type="button" class="btn btn-info addGoodConfig">新增配置</button>
                <button type="button" class="btn btn-info queryGoodSort" onclick="slidePanel('queryGoodSort')">查询排序</button>

            </div>
            <%--<c:if test="${fn:length(categories)>0}">--%>
            <%--<table>--%>
            <%--<thead>--%>
            <%--<th>排序</th>--%>
            <%--<th>分类名</th>--%>
            <%--<th>创建时间</th>--%>
            <%--<th>操作</th>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<tr>--%>

            <%--</tr>--%>

            <%--</tbody>--%>
            <%--</table>--%>
            <%--</c:if>--%>
            <c:if test="${fn:length(mls_sortgoodList)>0}">
                <table class="table table-striped">
                    <tr>
                        <th>名称</th>
                        <th>地址</th>
                    </tr>
                    <c:forEach items="${mls_sortgoodList}" var="sortgood">
                        <tr>
                            <td class="success">${sortgood.name}</td>
                            <td class="success">${sortgood.addressurl}</td>
                            <td>
                                <button type="button" class="btn btn-info editbtn" categoryid="${sortgood.id}">编辑</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>



        </div>
    </div>




    <%--添加主分类--%>
    <div id="addSortGood" class="f-none" style="width: 500px">
        <div class="f-title">新增配置</div>
        <form class="form-horizontal f-mt20" role="form"  id="sortGoodform">
            <div class="form-group">
                <label for="sortGoodnname" class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="sortGoodnname" placeholder="请输入姓名" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="addressurl" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="addressurl" placeholder="请输入排序"  name="addressurl">
                </div>
            </div>
            <div class="form-group">
                <label for="sortGoodType" class="col-sm-2 control-label">类型</label>
                <div class="col-sm-10">
                    <select name="type" id="sortGoodType" style="width: 100%">
                        <option value="1">流行</option>
                        <option value="2">热销</option>
                        <option value="3">新品</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-default btn-info " onclick="saveGoodConfig()">保存</button>
                    <button type="button" class="btn btn-default btn-danger" onclick="closeSlidePanel()">关闭</button>
                </div>
            </div>
        </form>
    </div>

    <div id="queryGoodSort" class="f-none" style="width: 500px">
        <form class="form-horizontal f-mt20" role="form"  id="queryGoodSortform">
            <div class="form-group">
                <div class="form-group">
                    <label class="col-sm-2 control-label">类别</label>
                    <div class="col-sm-10">
                        <select name="goodurl" class="f-wd100">
                            <c:forEach items="${mls_sortgoodList}" var="sortgood">
                                <option value="${sortgood.addressurl}">${sortgood.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="Goodnname" class="col-sm-2 control-label">名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="Goodnname" placeholder="请输入要查找的商品名称" name="goodname">
                    </div>
                </div>

                <div class="form-group">
                    <label for="sortresult" class="col-sm-2 control-label">排序位置:</label>
                    <div class="col-sm-10">
                        <label id="sortresult"  class="control-label sortresult"></label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-default btn-info " onclick="searchGoodSort()">查找</button>
                        <button type="button" class="btn btn-default btn-danger" onclick="closeSlidePanel()">关闭</button>
                    </div>
                </div>

                <%--<select name="type" id="sortGoodType" style="width: 100%">--%>
                    <%--<option value="1">流行</option>--%>
                    <%--<option value="2">热销</option>--%>
                    <%--<option value="3">新品</option>--%>
                <%--</select>--%>
            </div>


        </form>
    </div>

</div>


</body>
</html>
<script>
    function searchGoodSort() {
        $.ajax({
            type: "POST",
            url: "/mls/queryGoodSort",
            data: $('#queryGoodSortform').serialize(),
            success: function(data){
                var dataObj=eval("("+data+")")
                if(dataObj.status=="success"){
                    $('.sortresult').text(dataObj.entity.sort);
                }
            }
        });
    }

    //保存主分类
    function saveGoodConfig() {
        $.ajax({
            type: "POST",
            url: "/mls/addMlsSortGood",
            data: $('#sortGoodform').serialize(),
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
        $('.addGoodConfig').on('click', function () {
            slidePanel('addSortGood', '', {})
        })

    })

</script>