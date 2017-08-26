<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>管理员添加</title>
    <#include "../comm/upms-base.ftl" />
    <#include "../comm/upms-layui.ftl" />
    <link rel="stylesheet" href="../../../static/css/global.css"/>
</head>
<body class="shik_body">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <form class="layui-form layui-form-pane" action="/admin/save" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="username" lay-verify="required"
                               autocomplete="off" placeholder="请输入用户名" />
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="password" class="layui-input" name="password" lay-verify="required"
                               autocomplete="off" placeholder="请输入密码" />
                    </div>
                </div>
                <div class="layui-layer-btn layui-layer-btn-c">
                    <a class="layui-layer-btn0" lay-submit lay-filter="admin_submit">确认</a>
                    <a class="layui-layer-btn1 cancel">取消</a>
                </div>
            </form>
        </div>
    </div>
</body>
<script type="text/javascript" src="../../../static/js/admin.js"></script>
<script>
</script>
</html>