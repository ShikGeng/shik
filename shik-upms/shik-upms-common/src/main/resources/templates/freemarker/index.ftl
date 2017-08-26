<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>管理员添加</title>
    <#include "comm/upms-base.ftl" />
    <#include "comm/upms-layui.ftl" />
    <link rel="stylesheet" href="../../static/css/global.css"/>
    <link rel="stylesheet" href="../../static/css/index.css"/>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">shik-upms</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="javascript:;">管理员列表</a></li>
            <li class="layui-nav-item"><a href="javascript:;">商品管理</a></li>
            <li class="layui-nav-item"><a href="javascript:;">用户</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="shik_left">
                <li class="layui-nav-item layui-this"><a href="javascript:;" shik_url="/index">首页</a></li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">权限管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" shik_url="/admin/list">管理员列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body shik_content">
        <!-- 内容主体区域 -->
        <div class="layui-tab layui-tab-brief" lay-filter="shik_tab">
            <ul class="layui-tab-title">
                <li lay-id="/index" class="layui-this">首页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">首页内容</div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        copyright @2017 Shik
    </div>
</div>
<script type="text/javascript" src="../../static/js/index.js"></script>
<script>
</script>
</body>
</html>