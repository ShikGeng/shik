/**
 *
 * @author gengshikun
 * @date 2016/12/12
 */
layui.use(['form', 'layer', 'jquery', 'element', 'laypage'], function () {
    var form = layui.form;
        layer = layui.layer;
        element = layui.element;
        $ = layui.jquery;
        laypage = layui.laypage;

    // 左侧导航点击
    element.on('nav(shik_left)', function(data){
        console.log(data.children().attr('shik_url'));
        $.ajax({
            url: data.children().attr('shik_url'),
            dataType: 'html',
            success: function(html) {
                element.tabAdd('shik_tab', {
                    title: '管理员列表',
                    content: html, //支持传入html,
                    id: '选项卡标题的lay-id属性值'
                });
            }
        })

    });

    // tab页切换点击
    element.on('tab(shik_tab)', function(data){
        console.log(data);
    });

});