<%--
  Created by IntelliJ IDEA.
  User: dnys
  Date: 2016/12/9
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑类目</title>
</head>
<div class="f-title">编辑类目</div>
<body>
    <form class="form-horizontal f-mt20" role="form"  id="editcategoryform">
        <div class="form-group">
            <label for="categorynname" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="categorynname" placeholder="请输入姓名" name="name" value="${category.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="categorysort" class="col-sm-2 control-label">排序</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="categorysort" placeholder="请输入排序"  name="sort" value="${category.sort}">
            </div>
        </div>
        <%--<div class="form-group">--%>
            <%--<label for="categorysort" class="col-sm-2 control-label">排序</label>--%>
            <%--<select>--%>

            <%--</select>--%>
            <%--&lt;%&ndash;<div class="col-sm-10">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input type="text" class="form-control" id="categorystatus" placeholder="请输入排序"  name="sort" value="${category.status}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--</div>--%>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-default btn-info" onclick="updateCategory(${category.id})">保存</button>
                <button type="button" class="btn btn-default btn-danger" onclick="closeSlidePanel()">关闭</button>
            </div>
        </div>
    </form>
</body>
</html>
<script>
    function  updateCategory(id) {
        $.ajax({
            type: "POST",
            url: "/SSJ/category/updateCategory?id="+id,
            data: $('#editcategoryform').serialize(),
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