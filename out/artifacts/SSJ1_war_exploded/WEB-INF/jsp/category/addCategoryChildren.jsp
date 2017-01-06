<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 16/12/12
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="f-title">添加子类目</div>
<div  style="width: 500px">
    <form class="form-horizontal f-mt20" role="form"  id="categorychildrenform">
        <div class="form-group">
            <label for="categorychildrenname" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="categorychildrenname" placeholder="请输入姓名" name="name">
            </div>
        </div>
        <div class="form-group">
            <label for="categorychildrensort" class="col-sm-2 control-label">排序</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="categorychildrensort" placeholder="请输入排序"  name="sort">
            </div>
        </div>
        <input type="hidden" name="categoryid" id="categoryid" value="${categoryid}">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-default btn-info" onclick="saveChildren()">保存</button>
                <button type="button" class="btn btn-default btn-danger" onclick="closeSlidePanel()">关闭</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    //保存子分类
    function saveChildren() {
        $.ajax({
            type: "POST",
            url: "/SSJ/category/addSureCategoryChildren",
            data: $('#categorychildrenform').serialize(),
            success: function(data){
                var dataObj=eval("("+data+")")
                if(dataObj.status=="success"){
                    toastrSuccessMessage(dataObj.msg,'信息提示');
                    closeSlidePanel();
                }
            }
        });
    }
</script>
