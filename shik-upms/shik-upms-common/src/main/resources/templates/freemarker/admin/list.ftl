<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>管理员列表</title>
    <#include "../comm/upms-base.ftl" />
    <#include "../comm/upms-layui.ftl" />
    <link rel="stylesheet" href="../../../static/css/global.css"/>
</head>
<body class="shik_body">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>管理员列表</legend>
            </fieldset>
        </div>

        <div class="layui-col-xs12">
            <div class="layui-col-md3">
                <a class="layui-btn layui-btn-primary layui-btn-small admin_add" ><i class="layui-icon">&#xe654;</i></a>
            </div>
        </div>

        <div class="layui-col-xs12">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                    <tr>
                        <th>人物</th>
                        <th>民族</th>
                        <th>出场时间</th>
                        <th>格言</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>贤心</td>
                        <td>汉族</td>
                        <td>1989-10-14</td>
                        <td>人生似修行</td>
                    </tr>
                    <tr>
                        <td>张爱玲</td>
                        <td>汉族</td>
                        <td>1920-09-30</td>
                        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
                    </tr>
                    <tr>
                        <td>Helen Keller</td>
                        <td>拉丁美裔</td>
                        <td>1880-06-27</td>
                        <td> Life is either a daring adventure or nothing.</td>
                    </tr>
                    <tr>
                        <td>岳飞</td>
                        <td>汉族</td>
                        <td>1103-北宋崇宁二年</td>
                        <td>教科书再滥改，也抹不去“民族英雄”的事实</td>
                    </tr>
                    <tr>
                        <td>孟子</td>
                        <td>华夏族（汉族）</td>
                        <td>公元前-372年</td>
                        <td>猿强，则国强。国强，则猿更强！ </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="layui-col-xs12">
            <div class="shik_footer" id="shik_page"></div>
        </div>
    </div>
</body>
<script type="text/javascript" src="../../../static/js/admin.js"></script>
</html>