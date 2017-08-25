/**
 *
 * @author gengshikun
 * @date 2016/12/12
 */
layui.use(['form', 'layer', 'jquery', 'element'], function () {
    var form = layui.form;
        layer = layui.layer;
        element = layui.element;
        $ = layui.jquery;

    // 左侧导航点击
    element.on('nav(shik_left)', function(data){
        console.log(data);
    });

    // tab页切换点击
    element.on('tab(shik_tab)', function(data){
        console.log(data);
    });

});