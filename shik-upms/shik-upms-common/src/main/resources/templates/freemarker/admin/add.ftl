<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>管理员添加</title>
    <#include "../comm/upms-base.ftl" />
    <#include "../comm/upms-layui.ftl" />
    <link rel="stylesheet" href="../../..${BASE_PATH}/static/css/index.css"/>
</head>
<body>

<form class="layui-form layui-form-pane" action="${BASE_PATH}/admin/save" method="post">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>用户添加</legend>
    </fieldset>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" lay-verify="required" autocomplete="off" placeholder="请输入姓名"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="new-password" name="password" lay-verify="required" autocomplete="off" placeholder="请输入年龄"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

</body>
<script type="text/javascript" src="../../..${BASE_PATH}/static/js/admin.js"></script>
<script>
</script>
</html>