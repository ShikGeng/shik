<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录</title>
    <#include "comm/upms-base.ftl" />
    <#include "comm/upms-layui.ftl" />
    <link rel="stylesheet" href="../../static/css/global.css"/>
    <link rel="stylesheet" href="../../static/css/login.css"/>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="/"><div class="layui-logo">shik-upms</div></a>
    </div>


</div>
<div class="shik-box">
    <div class="shik-login-form">
        <span class="shik-login-title">登录</span>
        <form class="layui-form">
            <div class="layui-form-item">
                <input type="text" name="username" lay-verify="required" autocomplete="off" placeholder="账号" class="layui-input">
            </div>
            <div class="layui-form-item">
                <input type="text" name="password" lay-verify="required" autocomplete="off" placeholder="密码"
                       class="layui-input">
            </div>
            <div id="captcha1" class="layui-form-item">
                <p id="wait1" class="show">正在加载验证码......</p>
            </div>
            <div class="layui-form-item">
                <button class="shik-login-btn layui-btn-disabled" lay-submit="" lay-filter="submit">立即提交</button>
            </div>
        </form>
        <#--<div class="shik-login-operation">
            <a class="shik-forget" href="javascript:void(0)">忘记密码</a>
            <a class="shik-regin" href="javascript:void(0)">立即注册</a>
        </div>-->
    </div>
</div>
</body>
<script type="text/javascript" color="0,0,0" opacity='0.6' zIndex="-1" count="150" src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
<script src="http://static.geetest.com/static/tools/gt.js"></script>
<script type="text/javascript" src="/static/js/login.js"></script>
</html>